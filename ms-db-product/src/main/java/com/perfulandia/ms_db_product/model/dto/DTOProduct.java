package com.perfulandia.ms_db_product.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class DTOProduct {

    private Long id;

    @JsonProperty(value = "Nombre_Producto") 
    private String name_product;

    @JsonProperty(value = "Descripcion_Producto")
    private String desc_product;

    private Long precio;
}
