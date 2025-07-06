package com.perfulandia.ms_bs_sales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Venta BS")
                        .version("1.0")
                        .description("API para la gestión de ventas y detalles de ventas. Permite realizar operaciones CRUD sobre ventas, detalles de ventas, productos y clientes."));
    }
}
