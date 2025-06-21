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
public class SalesDetailDTO {
    private Long id;
    @JsonProperty("sales_id")
    private Long sales_id;
    @JsonProperty("quantity")
    private Long quantity;
    @JsonProperty("product_id")
    private Long product_id;
    
}
