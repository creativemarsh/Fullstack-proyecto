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
    @JsonProperty("id_sales_detail")
    private Long id;
    @JsonProperty("product")
    private ProductDTO product;
    @JsonProperty("quantity")
    private Long quantity; 
    @JsonProperty("sales_id")
    private Long sales_Id;
    
}
