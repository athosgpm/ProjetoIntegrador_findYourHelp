package com.projetointegrador.findYourHelp.config;

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
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	 @Bean
	    public Docket docket(){
	        return new Docket(DocumentationType.SWAGGER_2)
	                    .select()
	                    .apis( RequestHandlerSelectors.basePackage("com.projetointegrador.findYourHelp.controller") )
	                    .paths(PathSelectors.any())
	                    .build()
	                    .apiInfo(apiInfo());
	    }
	
	 private ApiInfo apiInfo(){
	        return new ApiInfoBuilder()
	                    .title("Projeto Integrador-Find Your Help")
	                    .description("API do Projeto Integrador Generation Brasil")
	                    .version("1.0")
	                    .contact(contact())
	                    .build();
	    }
	    private Contact contact(){
	        return new Contact("Projeto Integrador desenvolvido por:"
	        		+ " Andressa Ferreira, Athos Mesquita, Carolina Guida, "
	        		+ "Gustavo Guilhen, Maria Nazaré, Osvaldo Velasco, Tatiane Antunes ",
	                "https://github.com/athosgpm/ProjetoIntegrador_findYourHelp",
	                "Desenvolvedores Java Jr Full Stack");
	    }
}
