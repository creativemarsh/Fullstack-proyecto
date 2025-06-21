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

import com.perfulandia.ms_db_sales.model.dto.DTOClient;
import com.perfulandia.ms_db_sales.model.dto.ProductDTO;
import com.perfulandia.ms_db_sales.model.dto.SalesDTO;
import com.perfulandia.ms_db_sales.model.repositories.RepositorySales;
import com.perfulandia.ms_db_sales.model.repositories.RepositorySalesDetail;
import com.perfulandia.ms_db_sales.model.dto.SalesDetailDTO;
import com.perfulandia.ms_db_sales.model.entities.EntitySales;
import com.perfulandia.ms_db_sales.model.entities.EntitySalesDetail;

import java.time.format.DateTimeFormatter;

@Service
public class ServiceSales {

    @Autowired
    private RepositorySales repoSales;

    @Autowired
    private RepositorySalesDetail repoSalesDetail;



    ZoneId zonaHorariaSantiago = ZoneId.of("America/Santiago");
    ZonedDateTime fechaHoraActual = ZonedDateTime.now(zonaHorariaSantiago);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String fechaActualChile = fechaHoraActual.format(formatter);


    public EntitySales salesTranslateDTOToEntity(SalesDTO salesDTO) {
        EntitySales entitySales = new EntitySales();
        entitySales.setId(salesDTO.getId());
        entitySales.setSales_date(fechaActualChile);
        entitySales.setAmount(salesDTO.getAmount());
        entitySales.setClient_id(salesDTO.getClient().getId());
        return entitySales;
    }

    public SalesDTO salesTranslateEntityToDTO(EntitySales entitySales) {
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setId(entitySales.getId());
        salesDTO.setSales_date(entitySales.getSales_date());
        salesDTO.setAmount(entitySales.getAmount());
        DTOClient client = new DTOClient();
        client.setId(entitySales.getClient_id());
        salesDTO.setClient(client);
        return salesDTO;
    }

    public SalesDetailDTO salesDetailTranslateEntityToDTO(EntitySalesDetail entitySalesDetail) {
        SalesDetailDTO salesDetailDTO = new SalesDetailDTO();
        salesDetailDTO.setId(entitySalesDetail.getId());
        salesDetailDTO.setQuantity(entitySalesDetail.getQuantity());
        salesDetailDTO.setSales_Id(entitySalesDetail.getSalesId());
        ProductDTO product = new ProductDTO();
        product.setId(entitySalesDetail.getProduct_id());
        salesDetailDTO.setProduct(product);;
        return salesDetailDTO;
    }

    public EntitySalesDetail salesDetailTranslateDTOToEntity(SalesDetailDTO salesDetailDTO) {
        EntitySalesDetail entitySalesDetail = new EntitySalesDetail();
        entitySalesDetail.setId(salesDetailDTO.getId());
        entitySalesDetail.setQuantity(salesDetailDTO.getQuantity());
        entitySalesDetail.setSalesId(salesDetailDTO.getSales_Id());
        entitySalesDetail.setProduct_id(salesDetailDTO.getProduct().getId());
        return entitySalesDetail;
    }

    public List<SalesDetailDTO> translateListDetailEntityToDto (List<EntitySalesDetail> salesEntity) {
        List<SalesDetailDTO> salesDetailDTOs = new java.util.ArrayList<>();
        for (EntitySalesDetail entity : salesEntity){
            SalesDetailDTO salesDetailDTO = new SalesDetailDTO();
            salesDetailDTO.setId(entity.getId());
            salesDetailDTO.setQuantity(entity.getQuantity());
            salesDetailDTO.setSales_Id(entity.getSalesId());
            ProductDTO product = new ProductDTO();
            product.setId(entity.getProduct_id());
            salesDetailDTO.setProduct(product);
            salesDetailDTOs.add(salesDetailDTO);
        }
        return salesDetailDTOs;
    }


    public List<SalesDTO> getAllSales() {
        List<EntitySales> entitySales = repoSales.findAll();
        List<SalesDTO> salesDTO = new java.util.ArrayList<>();;
        for (EntitySales entity : entitySales) {
            salesDTO.add(salesTranslateEntityToDTO(entity));
        }
        return salesDTO;
}

    public SalesDTO getSalesById(Long id) {
        Optional<EntitySales> entitySales = repoSales.findById(id);
        SalesDTO salesDTO = new SalesDTO();
        if (entitySales.isPresent()) {
            salesDTO = salesTranslateEntityToDTO(entitySales.get());
        }
        return salesDTO ;
    }

    public EntitySales saveSales(SalesDTO salesDTO) {
        EntitySales entitySales = salesTranslateDTOToEntity(salesDTO);
        return repoSales.save(entitySales);
    }

    public EntitySales updateSales(SalesDTO salesDTO) {
        EntitySales entitySales = salesTranslateDTOToEntity(salesDTO);   
        return repoSales.save(entitySales);
    }

    public void deleteSales(Long id) {
        repoSales.deleteById(id);
    }




    public List<SalesDetailDTO> getSalesDetailBySalesId(Long salesId) {

        List<EntitySalesDetail> entitySalesDetails = repoSalesDetail.findBySalesId(salesId);
        List<SalesDetailDTO> salesDetailDTOs = new java.util.ArrayList<>();
        salesDetailDTOs = translateListDetailEntityToDto(entitySalesDetails);
        return salesDetailDTOs;
        
    }

    public SalesDetailDTO saveSalesDetail(SalesDetailDTO salesDetailDTO) {
        EntitySalesDetail entitySalesDetail = salesDetailTranslateDTOToEntity(salesDetailDTO);
        entitySalesDetail = repoSalesDetail.save(entitySalesDetail);
        return salesDetailTranslateEntityToDTO(entitySalesDetail);
        
    }

    public SalesDetailDTO updateSalesDetail(SalesDetailDTO salesDetailDTO) {
        EntitySalesDetail entitySalesDetail = salesDetailTranslateDTOToEntity(salesDetailDTO);
        repoSalesDetail.save(entitySalesDetail);
        return salesDetailDTO;
    }

    public void deleteSalesDetail(Long id) {
        repoSalesDetail.deleteById(id);
    }



}
