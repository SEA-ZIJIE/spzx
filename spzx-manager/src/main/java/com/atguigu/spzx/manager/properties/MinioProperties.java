package com.atguigu.spzx.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: MinioProperties
 * Package: com.atguigu.spzx.manager.properties
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/9/23 11:14
 * @Version 1.0
 */

@Data
@ConfigurationProperties(prefix = "spzx.minio")
public class MinioProperties {

    private String endpointUrl;
    private String accessKey;
    private String secreKey;
    private String bucketName;

}
