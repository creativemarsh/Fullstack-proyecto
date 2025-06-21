package com.perfulandia.ms_bs_sales.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


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
public class ProductDTO {
    private Long id;

    @JsonProperty(value = "Nombre_Producto") 
    private String name_product;

    @JsonProperty(value = "Descripcion_Producto")
    private String desc_product;

    @JsonProperty(value = "precio_Producto")
    private Long precio;
}
