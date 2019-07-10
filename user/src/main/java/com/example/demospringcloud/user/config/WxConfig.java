package com.example.demospringcloud.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:wxPay.properties"}, ignoreResourceNotFound = true,encoding = "UTF-8")
public class WxConfig {

    @Value("${WX_JYPT_AppId}")
    private String WX_JYPT_AppId;



    public String getWX_JYPT_AppId() {
        return WX_JYPT_AppId;
    }

    public void setWX_JYPT_AppId(String WX_JYPT_AppId) {
        this.WX_JYPT_AppId = WX_JYPT_AppId;
    }

}
