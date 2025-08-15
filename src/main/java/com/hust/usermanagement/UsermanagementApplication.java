package com.hust.usermanagement;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API for managing user",
				version = "v1.0",
				contact = @Contact(
						name = "Nguyen Hoang Nam",
						email = "hoangnam2004hp@gmail.com",
						url = "https://www.usermanagement.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.usermanagement.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url = "https://www.usermanagement.com/user_management.html"
		)
)
public class UsermanagementApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}

}
