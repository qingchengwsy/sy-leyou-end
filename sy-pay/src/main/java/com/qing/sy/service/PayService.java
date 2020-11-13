package com.qing.sy.service;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import me.chanjar.weixin.mp.api.WxMpService;
import com.github.binarywang.wxpay.service.WxPayService;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 微信支付
 * 2020/9/10
 * wsy
 */
public interface PayService {

     /**
      * 微信支付
      */
     HashMap<String,String> wxPay(String outTradeNo,String openid);
}
