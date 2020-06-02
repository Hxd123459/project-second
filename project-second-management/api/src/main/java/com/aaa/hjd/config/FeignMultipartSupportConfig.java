package com.aaa.hjd.config;

import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/26 0026
 * Time: 22:36
 * Description:
 */
@Configuration
public class FeignMultipartSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Encoder multipartFormEncoder(){
        // 为Encoder注入messageConverters
        return new SpringMultipartEncoder(new SpringEncoder(messageConverters));
    }

}
