package com.demosismos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
    public Docket produceApi(){
    return new Docket(DocumentationType.SWAGGER_2)
    .apiInfo(apiInfo())
    .select()
    .apis(RequestHandlerSelectors.basePackage("com.demosismos.controller"))
    .paths(paths())
    .build();
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	    .title("API Demosismos")
	    .description("API demo para Mineduc")
	    .version("1.0-SNAPSHOT")
	    .build();
	}
	
		private Predicate<String> paths() {

	    return Predicates.and(
	    PathSelectors.regex("/earthquakes.*"),
	    Predicates.not(PathSelectors.regex("/error.*")))
	    ;
	    
	 }
	 
	
	
}
