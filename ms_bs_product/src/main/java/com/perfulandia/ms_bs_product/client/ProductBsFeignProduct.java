package com.perfulandia.ms_bs_product.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.perfulandia.ms_bs_product.model.DTO.DTOProduct;


@FeignClient(name = "product", url = "http://localhost:8280/api/product")
public interface ProductBsFeignProduct {
    @GetMapping
    ResponseEntity<List<DTOProduct>> getAllProducts();

    @GetMapping("/{id}")
    ResponseEntity<DTOProduct> getProductById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<DTOProduct> saveProduct(@RequestBody DTOProduct dtoProduct);

    @PutMapping("/{id}")
    ResponseEntity<DTOProduct> updateProduct(@PathVariable("id") Long id, @RequestBody DTOProduct dtoProduct);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id);
}
