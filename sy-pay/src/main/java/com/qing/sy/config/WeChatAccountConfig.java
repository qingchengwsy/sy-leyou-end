package com.qing.sy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号配置
 */
@Data
@Component
@ConfigurationProperties(prefix ="wechat" )
public class WeChatAccountConfig {

    /** 公众平台开发者账号id */
    public  String appId;

    /** 开发者账号对应的密钥 */
    public  String secret;

    /** 商户号id */
    public  String mchId;

    /** 商户密钥 */
    public  String mchKey;

    /**服务商模式下的子商户公众账号ID. (服务商)*/
    private  String subAppId;

    /**服务商模式下的子商户号. (服务商)*/
    private  String subMchId;

    /** 商户证书地址 (退款需要)*/
    public  String keyPath;

    /** 微信支付异步通知地址 */
    public  String notifyUrl;
}
