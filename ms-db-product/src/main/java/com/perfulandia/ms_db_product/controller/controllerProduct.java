package com.perfulandia.ms_db_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.ms_db_product.model.dto.DTOProduct;
import com.perfulandia.ms_db_product.service.serviceProduct;


@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class controllerProduct {

    
    @Autowired
    serviceProduct serviceProduct;

    @GetMapping("")
    public DTOProduct getAProducts() {
        return serviceProduct.getAllProducts();
    }

    @GetMapping("/{id}")
    public DTOProduct getProductById(@PathVariable Long id) {
        return serviceProduct.getProductById(id);
    }

    @PostMapping("/post")
    public DTOProduct saveProduct (@RequestBody DTOProduct productDto) {
        serviceProduct.saveProduct(productDto);
        return productDto;
    }
    
}
