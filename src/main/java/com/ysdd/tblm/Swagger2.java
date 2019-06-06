package com.ysdd.tblm;

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

/**
 * swagger配置类
 *
 * @author 陈发
 * @date 2019/6/6 16:02
 */
@Configuration
@EnableSwagger2
public class Swagger2 {


    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本内容，比如扫描的包
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.ysdd.tblm.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api详细信息
     *
     * @return api详细信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置标题
                .title("Spring Boot 测试使用Swagger2 构建restfull API")
                //创建人
                .contact(new Contact("YSDD", "http://ysdd.mindpower.top", "ysdd@mindpower.top"))
                //版本号
                .version("1.0")
                //描述
                .description("一省到底官网")
                .build();
    }
}
