package com.perfulandia.ms_db_sales.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DTOClient {

    @JsonProperty("id_client")
    private Long id;

    @JsonProperty("Nombre_Cliente")
    private String nameClient;

    @JsonProperty("Correo_Cliente")
    private String emailClient;

    @JsonProperty("Telefono_Cliente")
    private String phoneClient;
}
