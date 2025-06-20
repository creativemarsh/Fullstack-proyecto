package com.perfulandia.ms_db_product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.ms_db_product.model.dto.DTOProduct;
import com.perfulandia.ms_db_product.model.entities.entityProduct;
import com.perfulandia.ms_db_product.service.serviceProduct;


@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class controllerProduct {

    
    @Autowired
    serviceProduct serviceProduct;

    @GetMapping("")
    public ResponseEntity<List<DTOProduct>> getAProducts() {
        List<DTOProduct> products = serviceProduct.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOProduct> getProductById(@PathVariable(name="id") Long id) {
        DTOProduct product = serviceProduct.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<entityProduct> saveProduct (@RequestBody DTOProduct productDto) {
        entityProduct savedProduct = serviceProduct.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOProduct> updateProduct(@PathVariable(name="id") Long id, @RequestBody DTOProduct dtoProduct) {
        DTOProduct updatedProduct = serviceProduct.updateProduct(id, dtoProduct);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name="id") Long id) {
        serviceProduct.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    
}
