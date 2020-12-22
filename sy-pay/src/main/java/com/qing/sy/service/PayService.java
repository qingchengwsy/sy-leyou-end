package com.qing.sy.service;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
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
     * @Description: 微信支付
     * @Param: [outTradeNo, openid]
     * @return: com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult
     * @Author: Su.Qing
     * @Date: 2020/12/22
     */
     WxPayMpOrderResult wxPay(String outTradeNo, String openid);

     /**
     * @Description: 微信退款
     * @Param: [outTradeNo]
     * @return: com.github.binarywang.wxpay.bean.result.WxPayRefundResult
     * @Author: Su.Qing
     * @Date: 2020/12/22
     */
     WxPayRefundResult refund(String outTradeNo);
}
