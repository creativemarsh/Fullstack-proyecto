package main.java.com.perfulandia.ms_bs_product.model.DTOProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOProduct {
    private Long id;

    @JsonProperty(value="Nombre_Producto")

    private String name_product;

    @JsonProperty(value="Descripcion_Producto")

    private String desc_product;

    @JsonProperty(value="precio_Producto")

    private Long precio;
}
