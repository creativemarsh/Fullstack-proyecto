package com.perfulandia.ms_db_sales.controller;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.ms_db_sales.model.dto.SalesDTO;
import com.perfulandia.ms_db_sales.model.entities.EntitySales;
import com.perfulandia.ms_db_sales.model.entities.EntitySalesDetail;
import com.perfulandia.ms_db_sales.service.ServiceSales;
import com.perfulandia.ms_db_sales.model.dto.SalesDetailDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
public class ControllerSales {
    @Autowired
    private ServiceSales serviceSales;

    @GetMapping("")
    public List<SalesDTO> getAllSales() {
        return serviceSales.getAllSales();
    }

    @GetMapping("/{id}")
    public SalesDTO getSalesById(@PathVariable(name = "id") Long id) {
        return serviceSales.getSalesById(id);
    }    

    @PostMapping("")
    public EntitySales saveSales(@RequestBody SalesDTO salesDTO) {
        return serviceSales.saveSales(salesDTO);
    }

    @PutMapping("")
    public EntitySales updateSales(@RequestBody SalesDTO salesDTO) {
        return serviceSales.updateSales(salesDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteSales(@PathVariable(name = "id") Long id) {
        serviceSales.deleteSales(id);
        return "Sale deleted successfully";
    }



    @GetMapping("/detail/{salesId}")
    public List<SalesDetailDTO> getSalesDetailBySalesId(@PathVariable(name = "salesId") Long salesId) {
        return serviceSales.getSalesDetailBySalesId(salesId);
    }


    
    @PostMapping("/detail")
    public SalesDetailDTO saveSalesDetail(@RequestBody SalesDetailDTO salesDetailDTO) {
        return serviceSales.saveSalesDetail(salesDetailDTO);
    }

    @PutMapping("/detail")
    public SalesDetailDTO updateSalesDetail(@RequestBody SalesDetailDTO salesDetailDTO) {
        return serviceSales.updateSalesDetail(salesDetailDTO);
    }

    @DeleteMapping("/detail/{id}")
    public String deleteSalesDetail(@PathVariable(name = "id")  Long id) {
        serviceSales.deleteSalesDetail(id);
        return "Sales detail deleted successfully";
    }
    
}
    

