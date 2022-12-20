package com.harrypotter.configuration;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //Easy initial configuration with all urls
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.harrypotter.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());//to output the information you must call the method
    }

    //Customize Documentation
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API HARRY POTTER")
                .description("Harry Potter API-REST application, with characters, spells and teachers.  " +
                        "A customized application to enjoy it and perform exercises.")
                .version("v1.0")
                .contact(new Contact("Ángel Luis Fernández Morante", "https://www.alfemodev.com", "contact@alfemodev.com"))
                .build();
    }
}
