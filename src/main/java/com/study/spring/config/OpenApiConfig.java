package com.study.spring.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OpenApiConfig {

	//@Bean

	public OpenAPI customOpenAPI() {

		return new OpenAPI()

				.info(new Info()

						.title("sample application API")

						.version("appVersion")

						.description("appDesciption")

						.termsOfService("http://swagger.io/terms/")

						.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}

}