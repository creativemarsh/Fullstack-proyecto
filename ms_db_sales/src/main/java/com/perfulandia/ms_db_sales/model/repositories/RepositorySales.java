package com.perfulandia.ms_db_sales.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.ms_db_sales.model.entities.EntitySales;

@Repository
public interface RepositorySales extends JpaRepository<EntitySales, Long> {

}
