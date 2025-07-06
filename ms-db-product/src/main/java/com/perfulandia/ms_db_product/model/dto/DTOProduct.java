package com.perfulandia.ms_db_product.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Schema(name = "DTOProduct")
public class DTOProduct {

    @Schema(description = "ID del producto", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;


    @Schema(description = "Nombre del producto", example = "Producto 1")
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @JsonProperty(value = "Nombre_Producto") 
    private String name_product;


    @Schema(description = "Descripción del producto", example = "Descripción del producto 1")
    @NotBlank(message = "La descripción del producto no puede estar vacía")
    @JsonProperty(value = "Descripcion_Producto")
    private String desc_product;

    @Schema(description = "Precio del producto", example = "100")
    @NotBlank(message = "El precio del producto no puede estar vacío")
    @JsonProperty(value = "precio_Producto")
    private Long precio;
}
