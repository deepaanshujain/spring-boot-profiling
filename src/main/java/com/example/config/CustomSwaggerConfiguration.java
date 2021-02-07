package com.example.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CustomSwaggerConfiguration extends WebMvcConfigurationSupport {

	@Bean
	public Docket productApi() {

		List<Parameter> parametr = new ArrayList<>();

		return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/api/*")).build().apiInfo(metaData())
				.globalOperationParameters(parametr);
	}

	private ApiInfo metaData() {

		ApiInfo apiInfo = new ApiInfo("Profiles API", "Profile", "1.0", "Terms of service",
				new Contact("Ithuba", "https://www.nationallottery.co.za", "info@nationallottery.co.za"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
		return apiInfo;
	}

}
