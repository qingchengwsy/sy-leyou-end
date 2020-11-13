package com.qing.sy.service.imple;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.qing.sy.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 微信支付
 * 2020/9/10
 * wsy
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private WxPayService wxPayService;

    @Override
    public HashMap<String,String> wxPay(String outTradeNo,String openid) {
        WxPayUnifiedOrderRequest orderRequest=new WxPayUnifiedOrderRequest();
        HashMap<String,String> request=new HashMap<>();
        orderRequest.setOutTradeNo("13141111");
        orderRequest.setTotalFee(1);
        orderRequest.setOpenid(openid);
        orderRequest.setBody("myPay");
        orderRequest.setTradeType("JSAPI");
        orderRequest.setSpbillCreateIp("127.0.0.1");
        log.warn("【微信支付request】= {}",orderRequest);
        WxPayUnifiedOrderResult result=null;
        try {
            result = wxPayService.unifiedOrder(orderRequest);
            if (result.getResultCode().equals("SUCCESS")){
                request.put("appId",result.getAppid());
                request.put("timeStamp",String.valueOf(System.currentTimeMillis()));
                request.put("nonceStr",result.getNonceStr());
                request.put("prepay_id",result.getPrepayId());
                request.put("paySign",result.getSign());
            }
        } catch (WxPayException e) {
            log.error("调用微信统一下单error："+e);
        }
        return request;
    }

}
