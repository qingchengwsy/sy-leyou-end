package com.qing.sy.controller;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.BaseWxPayServiceImpl;
import com.qing.sy.service.PayService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/gw/wxpay")
@Slf4j
public class WxPayController {

    private final String openid = "opY-7wH53pfQuiWRxnk7JFAgJO2M";

    private WxMpService wxMpService;
    private WxPayService wxPayService;
    private PayService payService;

    public WxPayController(WxMpService wxMpService, WxPayService wxPayService, PayService payService) {
        this.wxMpService = wxMpService;
        this.wxPayService = wxPayService;
        this.payService = payService;
    }

    /**
     * 获取code
     * @param returnUrl
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam(value = "returnUrl") String returnUrl) {
        String url = "http://crm.51daiqi.com/rbcrm_war_exploded/gw/wxpay/userInfo";
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
    @GetMapping(value = "/createOrder")
    public ModelAndView wxPay(@RequestParam(value = "outTradeNo") String outTradeNo) {
        ModelAndView mode = new ModelAndView();
        mode.addObject("orderResult", payService.wxPay(outTradeNo, openid));
        mode.setViewName("pay");
        return mode;
    }

    /**
     * 订单支付完成之后异步回调
     * @return
     */
    @PostMapping(value = "/wxPayNotifyifyUrl")
    @ResponseBody
    public String notifyWeiXinPay(@RequestBody String xmlDate) throws WxPayException {
        final WxPayOrderNotifyResult notifyResult = wxPayService.parseOrderNotifyResult(xmlDate);
        log.info("支付成功后异步回调返回数据:{}",notifyResult);
        //TODO 业务逻辑
        return WxPayNotifyResponse.success("成功");
    }

    @PostMapping("refund")
    @ResponseBody
    public WxPayRefundResult refund(@RequestParam(value = "outTradeNo") String outTradeNo){
       return payService.refund(outTradeNo);
    }

    @PostMapping("/wxRefundNotifyUrl")
    @ResponseBody
    public String parseRefundNotifyResult(@RequestBody String xmlData) throws WxPayException {
        final WxPayRefundNotifyResult notifyResult = wxPayService.parseRefundNotifyResult(xmlData);
        log.info("退款异步回调返回数据:{}",notifyResult);
        //WxPayRefundNotifyResult.ReqInfo reqInfo = notifyResult.getReqInfo(); //解密
        // TODO 根据自己业务场景需要构造返回对象
        return WxPayNotifyResponse.success("成功");
    }
}
