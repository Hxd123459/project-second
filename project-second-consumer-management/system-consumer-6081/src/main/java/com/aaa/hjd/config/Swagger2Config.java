package com.aaa.hjd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.aaa.hjd.status.RequestUrlProperties.PACKAGE_CONTROLLER_URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/16 0016
 * Time: 12:49
 * Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                // 选择swagger具体生效的接口是什么？(service, controller, mapper)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aaa.hjd.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
       return new ApiInfoBuilder()
               .title("测绘管理系统")
               .description("阳江市的测绘管理系统")
               .contact(new Contact("AAA-hjd","博客地址","1481808136@qq.com"))
               .version("1.0")
               .build();
    }
}
