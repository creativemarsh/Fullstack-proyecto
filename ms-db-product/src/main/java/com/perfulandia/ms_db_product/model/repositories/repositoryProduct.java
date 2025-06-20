package com.perfulandia.ms_db_product.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.ms_db_product.model.entities.entityProduct;

@Repository
public interface repositoryProduct extends JpaRepository<entityProduct, Long> {

}
