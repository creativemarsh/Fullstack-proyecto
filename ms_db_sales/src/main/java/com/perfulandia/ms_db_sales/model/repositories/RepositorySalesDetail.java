package com.perfulandia.ms_db_sales.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.ms_db_sales.model.entities.EntitySalesDetail;

@Repository
public interface RepositorySalesDetail extends JpaRepository<EntitySalesDetail, Long> {

    public List<EntitySalesDetail> findBySalesId(Long sales_Id);

}
