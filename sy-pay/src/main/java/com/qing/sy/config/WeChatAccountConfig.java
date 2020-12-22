package com.qing.sy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {

    /**
     * 公众平台开发者账号id
     */
    private String appId;

    /**
     * 开发者账号对应的密钥
     */
    private String secret;

    /**
     * 商户号id
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 服务商模式下的子商户公众账号ID. (服务商)
     */
    private String subAppId;

    /**
     * 服务商模式下的子商户号. (服务商)
     */
    private String subMchId;

    /**
     * 商户证书地址 (退款需要)
     */
    private String keyPath;

    /**
     * 支付完成后异步回调地址
     */
    private String notifyUrl;

    /**
     * 申请退款完成后异步回调地址
     */
    private String refundNotifyUrl;
}
