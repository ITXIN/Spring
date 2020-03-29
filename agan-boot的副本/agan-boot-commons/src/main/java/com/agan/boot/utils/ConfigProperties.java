package com.agan.boot.utils;

import lombok.Data;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "config", ignoreUnknownFields = false)
//@PropertySource(value = "config.properties")
@Data
public class ConfigProperties {
    private String phone;
    private String wife;
}
