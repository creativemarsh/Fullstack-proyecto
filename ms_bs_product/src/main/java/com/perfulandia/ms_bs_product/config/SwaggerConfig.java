package com.perfulandia.ms_bs_product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("API de Productos BS")
                        .version("1.0")
                        .description("API para la gestión de productos, permitiendo operaciones CRUD a través de Feign Client."));
    }


}
