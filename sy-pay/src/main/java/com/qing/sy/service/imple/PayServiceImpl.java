package com.qing.sy.service.imple;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.qing.sy.config.WeChatAccountConfig;
import com.qing.sy.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
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

    private WxPayService wxPayService;
    private WeChatAccountConfig weChatAccountConfig;

    public PayServiceImpl(WxPayService wxPayService, WeChatAccountConfig weChatAccountConfig) {
        this.wxPayService = wxPayService;
        this.weChatAccountConfig = weChatAccountConfig;
    }

    @Override
    public WxPayMpOrderResult wxPay(String outTradeNo, String openid) {
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
        /**根据订单Id 可以查出订单信息*/
        HashMap<String, String> request = new HashMap<>();
        orderRequest.setOutTradeNo(RandomStringUtils.randomNumeric(16));
        orderRequest.setTotalFee(1);
        orderRequest.setOpenid(openid);
        orderRequest.setBody("body");
        orderRequest.setSpbillCreateIp("127.0.0.1");
        WxPayMpOrderResult result = null;
        try {
            log.warn("【微信支付request】= {}", orderRequest);
            result = wxPayService.createOrder(WxPayConstants.TradeType.Specific.JSAPI, orderRequest);
            log.info("生成预付单信息: result:{}", result);
        } catch (WxPayException e) {
            log.error("调用微信统一下单error：{}",e);
        }
        return result;
    }

    @Override
    public WxPayRefundResult refund(String outTradeNo) {
        WxPayRefundRequest request = new WxPayRefundRequest();
        request.setTransactionId("4200000915202012227991739938");
        request.setOutRefundNo(RandomStringUtils.randomNumeric(16));
        request.setTotalFee(1);
        request.setRefundFee(1);
        request.setNotifyUrl(weChatAccountConfig.getRefundNotifyUrl());
        WxPayRefundResult refund = null;
        try {
            log.info("申请退款请求信息:{}", request);
            refund = wxPayService.refund(request);
            log.info("申请退款返回信息:{}", refund);
        } catch (WxPayException e) {
            log.error("refund申请退款error: {}", e);
        }
        return refund;
    }
}
