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
public class SalesDTO {
    @JsonProperty("id_sales")
    private Long id;
    @JsonProperty("amount")
    private Long amount;
    @JsonProperty("sales_date")
    private String sales_date;
    @JsonProperty("client")
    private DTOClient client;
}
