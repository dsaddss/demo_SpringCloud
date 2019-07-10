package com.example.demospringcloud.user.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
//@PropertySource(value = {"classpath:myml.yml"}, ignoreResourceNotFound = true,encoding = "UTF-8")
//@ConfigurationProperties("myml")
public class ApplicationConfig implements Serializable, InitializingBean {

    private final long serialVersionUID = -2637199581265724580L;

    @Value("${myml.appId}")
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        appId = appId;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("myml.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
