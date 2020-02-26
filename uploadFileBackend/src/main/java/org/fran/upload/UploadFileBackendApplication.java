package org.fran.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UploadFileBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadFileBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST",
				// "PUT", "DELETE")
				// better we specify the mapping and the allowed origin:
				registry.addMapping("/api/v1/files").allowedOrigins("http://localhost:4200")
						.allowedHeaders("Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Methods",
								"Access-Control-Allow-Headers", "Authorization")
						.exposedHeaders("Content-Type", "Access-Control-Allow-Origin", "Access-Control-Allow-Methods",
								"Access-Control-Allow-Headers", "Authorization")
						.allowCredentials(true);
			}
		};
	}
	
}
