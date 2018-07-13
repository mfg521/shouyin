package com.zhonghuilv.shouyin.configs;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).useDefaultResponseMessages(false)
                .groupName("shouyin")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                //.globalResponseMessage(RequestMethod.GET,customerResponseMessage())
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhonghuilv.shouyin.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("收银接口文档")
                .description("")
                .version("")
                .license("")
                .licenseUrl("")
                .build();
    }
}
