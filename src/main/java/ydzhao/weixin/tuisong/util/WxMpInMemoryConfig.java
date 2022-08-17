package ydzhao.weixin.tuisong.util;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxMpInMemoryConfig {
    private static String appId = "wxff82400bbf9810d4";
    private static String secret = "a8c48151baf34212d2eed624c94e885d";

    @Bean("WxMpService")
    public WxMpService getWxMpService() {
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        return wxMpService;
    }
}
