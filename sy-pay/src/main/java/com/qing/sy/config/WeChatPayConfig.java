package com.qing.sy.config;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import me.chanjar.weixin.common.bean.WxCardApiSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 微信支付配置
 */
@Component
public class WeChatPayConfig {

    @Autowired
    private WeChatAccountConfig weChatAccountConfig;

    @Bean
    public WxPayService wxPayService(){
        WxPayConfig wxPayConfig=new WxPayConfig();
        wxPayConfig.setAppId(weChatAccountConfig.getAppId());
        wxPayConfig.setMchId(weChatAccountConfig.getMchId());
        wxPayConfig.setMchKey(weChatAccountConfig.getMchKey());
        wxPayConfig.setNotifyUrl(weChatAccountConfig.getNotifyUrl());
        //可以指定是否使用沙箱环境
        wxPayConfig.setUseSandboxEnv(false);
        WxPayService wxPayService=new WxPayServiceImpl();
        wxPayService.setConfig(wxPayConfig);
        return wxPayService;
    }
}
