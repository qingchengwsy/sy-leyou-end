package com.qing.sy.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 获取微信openId配置
 */
@Component
public class WeChatMpConfig {

    @Autowired
    private WeChatAccountConfig weChatAccountConfig;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpDefaultConfigImpl wxMpDefaultConfig=new WxMpDefaultConfigImpl();
        wxMpDefaultConfig.setAppId(weChatAccountConfig.getAppId());
        wxMpDefaultConfig.setSecret(weChatAccountConfig.getSecret());
        wxMpService.setWxMpConfigStorage(wxMpDefaultConfig);
        return wxMpService;
    }
}
