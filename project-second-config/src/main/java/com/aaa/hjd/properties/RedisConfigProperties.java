package com.aaa.hjd.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/13 0013
 * Time: 18:47
 * Description:
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@PropertySource("classpath:properties/redis_cluster.properties")
@Data
public class RedisConfigProperties {
    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}
