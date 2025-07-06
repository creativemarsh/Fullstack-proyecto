package com.perfulandia.ms_bs_sales.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.perfulandia.ms_bs_sales.model.dto.ProductDTO;

@FeignClient(name = "product", url = "http://localhost:8281/api/product")
public interface BsOpenFeignProduct {
    @GetMapping("")
    public List<ProductDTO> getAllProducts();

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable(name = "id") Long id);

    @PostMapping("")
    public String saveProduct(@RequestBody ProductDTO productDTO);
}
