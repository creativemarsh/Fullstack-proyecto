package com.perfulandia.ms_bs_sales.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.perfulandia.ms_bs_sales.model.dto.SalesDTO;
import com.perfulandia.ms_bs_sales.model.dto.SalesDetailDTO;

@FeignClient(name = "sales", url = "http://localhost:8080/sales")
public interface BsOpenFeignSales {
    
    @GetMapping("")
    List<SalesDTO> getAllSales();
    
    @GetMapping("/{id}")
    SalesDTO getSaleById(@PathVariable(name = "id") Long id);
    
    @PostMapping("")
    SalesDTO createSale(@RequestBody SalesDTO salesDTO);
    
    @PutMapping("")
    SalesDTO updateSale(@RequestBody SalesDTO salesDTO);

    @DeleteMapping("{id}")
    String deleteSale(@PathVariable(name="id") Long id);





    @GetMapping("/detail/{salesId}")
    List<SalesDetailDTO> getSalesByClientId(@PathVariable(name = "salesId") Long salesId);




    @PostMapping("/detail")
    SalesDetailDTO saveSalesDetail(@RequestBody  SalesDetailDTO salesDetailDTO);

    @PutMapping("/detail")
    SalesDetailDTO updateSalesDetail(@RequestBody SalesDetailDTO salesDetailDTO);

    @DeleteMapping("/detail/{id}")
    String deleteSalesDetail(@PathVariable(name = "id") Long id);



}
