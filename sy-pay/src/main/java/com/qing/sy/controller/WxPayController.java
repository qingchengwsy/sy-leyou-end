package com.qing.sy.controller;

import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.qing.sy.service.PayService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

@Controller
@RequestMapping("/wxpay")
@Slf4j
public class WxPayController {

    private final String openid="oT-N7s2IV3uIZ8Qz9hJiGNEj9PwQ";

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private PayService payService;

    /**
     * 获取code
     * @param returnUrl
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam(value = "returnUrl") String returnUrl) {
        String url = "http://crm.51daiqi.com/wxpay/userInfo";
        String redirectUrl = null;
        try {
            redirectUrl = wxMpService.getOAuth2Service().buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("【微信支付】获取code error：" + e);
        }
        return "redirect:" + redirectUrl;
    }

    /**
     * 获取openId
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam(value = "code") String code,
                           @RequestParam(value = "state") String state) {
        WxMpUser wxMpUser = null;
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.getOAuth2Service().getAccessToken(code);
            /**获得用户基本信息*/
            wxMpUser = wxMpService.getOAuth2Service().getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            log.error("【微信支付】code换取accessToken" + e);
        }
        String openId = wxMpUser.getOpenId();
        log.info("获取openId:{}", openId);
        return "redirect:" + state + "?openid=" + openId;
    }

    /**
     * 微信统一下单接口
     * @param outTradeNo
     * @return
     */
    @PostMapping(value = "/createOrder")
    @ResponseBody
    public ModelAndView wxPay(@RequestParam(value = "outTradeNo") String outTradeNo){
        HashMap<String, String> hashMap = payService.wxPay(outTradeNo, openid);
        return new ModelAndView("pay",hashMap);
    }

    /**
     * 订单支付完成之后异步回调
     * @return
     */
//    @RequestMapping("/notify")
//    public String payNotify(HttpServletRequest request, HttpServletResponse response) {
//        try {
//         //   String xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
//            WxPayOrderNotifyResult result = wxPayService.parseOrderNotifyResult(xmlResult);
//
//            // 加入自己处理订单的业务逻辑，需要判断订单是否已经支付过，否则可能会重复调用
//            String orderId = result.getOutTradeNo();
//            String tradeNo = result.getTransactionId();
//            String totalFee = BaseWxPayResult.fenToYuan(result.getTotalFee());
//            return WxPayNotifyResponse.success("处理成功!");
//        } catch (Exception e) {
//            log.error("微信回调结果异常,异常原因{}", e.getMessage());
//            return WxPayNotifyResponse.fail(e.getMessage());
//        }
//    }
}
