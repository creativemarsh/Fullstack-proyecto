package com.perfulandia.ms_db_sales.config;

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
                        .title("API de Venta DB")
                        .version("1.0")
                        .description("API para gestionar ventas, clientes, productos y detalles de ventas en la base de datos."));
    }


}
