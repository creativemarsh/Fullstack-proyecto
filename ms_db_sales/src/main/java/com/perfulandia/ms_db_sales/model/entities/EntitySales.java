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
@Table(name = "sales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntitySales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "sales_date")
    private String sales_date;
    @Column(name = "client_id")
    private Long client_id;

}
