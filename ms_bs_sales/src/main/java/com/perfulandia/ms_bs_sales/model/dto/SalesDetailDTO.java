package com.perfulandia.ms_bs_sales.model.dto;

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
public class SalesDetailDTO {
    @Schema(description = "Identificador único del detalle de venta",accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty("id_sales_detail")
    private Long id;

    @Schema(description = "Producto asociada al detalle", example = "{\"id\":1}")
    @NotBlank(message = "El producto no puede estar en blanco")
    @JsonProperty("product")
    private ProductDTO product;

    @Schema(description = "Cantidad del producto", example = "2")
    @NotBlank(message = "La cantidad no puede estar en blanco")
    @JsonProperty("quantity")
    private Long quantity; 

    @Schema(description = "Id Venta asociada al detalle", example = "1")
    @NotBlank(message = "El ID de la venta no puede estar en blanco")
    @JsonProperty("sales_id")
    private Long sales_Id;
}
