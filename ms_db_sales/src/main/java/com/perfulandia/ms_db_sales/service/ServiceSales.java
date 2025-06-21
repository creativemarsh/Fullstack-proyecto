package com.perfulandia.ms_db_sales.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.SlicedPathAccessFragmentContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.perfulandia.ms_db_sales.model.dto.SalesDTO;
import com.perfulandia.ms_db_sales.model.entities.EntitySales;
import com.perfulandia.ms_db_sales.model.repositories.RepositorySales;
import java.time.format.DateTimeFormatter;

@Service
public class ServiceSales {

    @Autowired
    private RepositorySales repoSales;


    ZoneId zonaHorariaSantiago = ZoneId.of("America/Santiago");
    ZonedDateTime fechaHoraActual = ZonedDateTime.now(zonaHorariaSantiago);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String fechaActualChile = fechaHoraActual.format(formatter);


    public EntitySales translateDTOToEntity(SalesDTO salesDTO) {
        EntitySales  entitySales = new EntitySales();
        entitySales.setId(salesDTO.getId());
        entitySales.setSales_date(salesDTO.getSales_date());
        entitySales.setAmount(salesDTO.getAmount());
        entitySales.setClient_id(salesDTO.getClient_id());
        return entitySales;
    }

    public SalesDTO translateEntityToDTO(EntitySales entitySales) {
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setId(entitySales.getId());
        salesDTO.setSales_date(entitySales.getSales_date());
        salesDTO.setAmount(entitySales.getAmount());
        salesDTO.setClient_id(entitySales.getClient_id());
        return salesDTO;
    }

    public List<SalesDTO> getAllSales() {
        List<EntitySales> entitySales = repoSales.findAll();
        List<SalesDTO> salesDTO = new java.util.ArrayList<>();;
        for (EntitySales entity : entitySales) {
            salesDTO.add(translateEntityToDTO(entity));
        }
        return salesDTO;
}

    public SalesDTO getSalesById(Long id) {
        Optional<EntitySales> entitySales = repoSales.findById(id);
        SalesDTO salesDTO = new SalesDTO();
        if (entitySales.isPresent()) {
            salesDTO = translateEntityToDTO(entitySales.get());
        }
        return salesDTO ;
    }

    public EntitySales saveSales(SalesDTO salesDTO) {
        EntitySales entitySales = new EntitySales();
        entitySales.setId(salesDTO.getId());
        
        entitySales.setSales_date(fechaActualChile);
        entitySales.setAmount(salesDTO.getAmount());
        entitySales.setClient_id(salesDTO.getClient_id());
        return repoSales.save(entitySales);
    }

    public EntitySales updateSales(SalesDTO salesDTO) {
        EntitySales entitySales = translateDTOToEntity(salesDTO);
        return repoSales.save(entitySales);
    }

    public void deleteSales(Long id) {
        repoSales.deleteById(id);
    }



}
