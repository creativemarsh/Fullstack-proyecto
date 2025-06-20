package com.perfulandia.ms_db_product.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ms_db_product.model.entities.entityProduct;

public interface repositoryProduct extends JpaRepository<entityProduct, Long> {

}
