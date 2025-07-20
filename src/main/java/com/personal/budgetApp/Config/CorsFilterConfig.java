package com.personal.budgetApp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsFilterConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("localhost:8080")
                .allowedMethods("POST", "PUT", "GET", "DELETE")
                .allowedHeaders("Request-Id", "Client-Id", "Authorization")
                .allowCredentials(true);
    }
}
