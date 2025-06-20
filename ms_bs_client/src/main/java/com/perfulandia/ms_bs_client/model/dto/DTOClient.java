package com.perfulandia.ms_bs_client.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTOClient {
    private Long id;

    @JsonProperty("Nombre_Cliente")
    private String nameClient;

    @JsonProperty("Correo_Cliente")
    private String emailClient;

    @JsonProperty("Telefono_Cliente")
    private String phoneClient;
}
