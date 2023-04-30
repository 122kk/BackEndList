package com.backendlist.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author kj
 * @date 2023/3/5
 * @apiNote
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.backendlist.controller"))
               // .apis(RequestHandlerSelectors.basePackage(""))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo(){
        Contact contact=new Contact("kj","","1654275119@qq.com");
        return new ApiInfo(
                "review",
                "review",
                "v1.0",
                "https://www.mjorkj.top",
                contact,
                "",
                "",
                new ArrayList()
        );
    }
}
