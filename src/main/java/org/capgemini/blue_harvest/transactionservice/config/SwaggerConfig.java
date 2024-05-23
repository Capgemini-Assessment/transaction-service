package org.capgemini.blue_harvest.transactionservice.config;

import org.capgemini.blue_harvest.transactionservice.constant.APIConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI transactionServiceApiOpenAPI() {
		return new OpenAPI().info(new Info().title(APIConstants.API_TITLE).description(APIConstants.API_DESCRIPTION)
				.version(APIConstants.API_VERSION).contact(new Contact().email(APIConstants.CONTACT_EMAIL)));
	}
}