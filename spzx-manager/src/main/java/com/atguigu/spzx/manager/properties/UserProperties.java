package com.atguigu.spzx.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * ClassName: UserProperties
 * Package: com.atguigu.spzx.manager.properties
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/20 0:05
 * @Version 1.0
 */

@Data
@ConfigurationProperties(prefix = "spzx.auth")
public class UserProperties {

    private List<String> noAuthUrls;
}
