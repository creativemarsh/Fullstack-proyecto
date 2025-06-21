package com.perfulandia.ms_db_sales.model.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sales_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntitySalesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sales_id")
    private Long sales_id;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "product_id")
    private Long product_id;
}
