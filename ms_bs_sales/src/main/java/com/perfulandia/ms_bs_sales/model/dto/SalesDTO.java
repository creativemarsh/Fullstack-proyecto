package com.perfulandia.ms_bs_sales.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {



    @Schema(description = "Identificador único de la venta",accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("id_sales")
    private Long id;

    @Schema(description = "Monto total de la venta", example = "100")
    @NotBlank(message = "El monto no puede estar en blanco")
    @JsonProperty("amount")
    private Long amount;

    
    @Schema(description = "Fecha de la venta",accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("sales_date")
    private String sales_date;

    @Schema(description = "Identificador del cliente asociado a la venta", example = "{\"id_client\":1}")
    @NotBlank(message = "El ID del cliente no puede estar en blanco")
    @JsonProperty("client")
    private DTOClient client;
}
