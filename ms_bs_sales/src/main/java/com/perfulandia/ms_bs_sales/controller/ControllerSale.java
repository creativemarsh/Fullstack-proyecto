package com.perfulandia.ms_bs_sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.ms_bs_sales.model.dto.DTOClient;
import com.perfulandia.ms_bs_sales.model.dto.ProductDTO;
import com.perfulandia.ms_bs_sales.model.dto.SalesDTO;
import com.perfulandia.ms_bs_sales.model.dto.SalesDetailDTO;
import com.perfulandia.ms_bs_sales.service.SalesService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
public class ControllerSale {

    @Autowired
    private SalesService salesService;

    @GetMapping("")
    private List<SalesDTO> getAllSales() {
        return salesService.getAllSales();
    }


    @GetMapping("/{id}")
    private SalesDTO getSaleById(@PathVariable(name="id") Long id) {
        return salesService.getSalesById(id);
    }


    @PostMapping("")
    private String createSale(@RequestBody SalesDTO salesDTO) {
        salesService.createSale(salesDTO);
        return "Venta creada con éxito";
    }

    @PutMapping("")
    private String updateSale(@RequestBody SalesDTO salesDTO) {
        salesService.updateSale(salesDTO);
        return "Cambio de venta exitoso";
    }

    @DeleteMapping("/{id}")
    private String deleteSale(@PathVariable(name="id") Long id) {
        return salesService.deleteSale(id);
    }




    @GetMapping("/detail/{salesId}")
    private List<SalesDetailDTO> getSalesByClientId(@PathVariable(name="salesId") Long id) {
        return salesService.getSalesByClientId(id);
    }

    

    @PostMapping("/detail")
    private SalesDetailDTO createSalesDetail(@RequestBody SalesDetailDTO salesDetailDTO) {
        return salesService.createSalesDetail(salesDetailDTO);
    }

    @PutMapping("/detail") 
    private SalesDetailDTO updateSalesDetail(@RequestBody SalesDetailDTO salesDetailDTO) {
        return salesService.updateSalesDetail(salesDetailDTO);
    }

    @DeleteMapping("/detail/{id}")
    private String deleteSalesDetail(@PathVariable(name="id") Long id) {
        return salesService.deleteSalesDetail(id);
    }

    @PostMapping("/product")
    private String createProduct(@RequestBody ProductDTO productDTO) {
        return salesService.saveProduct(productDTO);
    }
    
    
}
