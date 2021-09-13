package org.example.heima.userservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// Sep 9, 2021
@Data
@Component
@ConfigurationProperties(prefix = "pattern")            // 绑定 properties file 中的外部配置
public class PatternProperties {

    private String dateFormat;

    private String envSharedValue;

    private String name;
}
