
package com.perfulandia.ms_db_sales.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

    private Long id;

    @JsonProperty(value = "Nombre_Producto") 
    private String name_product;

    @JsonProperty(value = "Descripcion_Producto")
    private String desc_product;

    @JsonProperty(value = "precio_Producto")
    private Long precio;
}
