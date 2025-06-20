package com.perfulandia.ms_db_client.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * DTO (Data Transfer Object) para representar los datos del cliente.
 * Facilita la comunicación entre el backend y otros sistemas o servicios.
 */
@Getter // Genera automáticamente los métodos get
@Setter // Genera automáticamente los métodos set
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
public class DTOClient {

    private Long id;

    @JsonProperty("Nombre_Cliente")
    private String nameClient;

    @JsonProperty("Correo_Cliente")
    private String emailClient;

    @JsonProperty("Telefono_Cliente")
    private String phoneClient;
}
