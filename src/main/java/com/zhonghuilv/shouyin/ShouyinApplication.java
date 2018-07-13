package com.zhonghuilv.shouyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableWebMvc
@EnableConfigurationProperties
@EnableSwagger2
public class ShouyinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShouyinApplication.class, args);
    }

}
