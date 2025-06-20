package main.java.com.perfulandia.ms_bs_product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.perfulandia.ms_bs_product.client.ProductBsFeignProduct;
import com.perfulandia.ms_bs_product.model.DTO.DTOProduct;

public class ServiceProduct {

    @Autowired
    private ProductBsFeignProduct productBsFeignProduct;

    public List<DTOProduct> getAllProducts() {
        ResponseEntity<List<DTOProduct>> response = productBsFeignProduct.getAllProducts();
        return response.getBody();
    }

    public DTOProduct getProductById(Long id) {
        ResponseEntity<DTOProduct> response = productBsFeignProduct.getProductById(id);
        return response.getBody();
    }

    public DTOProduct saveProduct(DTOProduct dtoProduct) {
        ResponseEntity<DTOProduct> response = productBsFeignProduct.saveProduct(dtoProduct);
        return response.getBody();
    }

    public DTOProduct updateProduct(Long id, DTOProduct dtoProduct) {
        ResponseEntity<DTOProduct> response = productBsFeignProduct.updateProduct(id, dtoProduct);
        return response.getBody();
    }

    public void deleteProduct(Long id) {
        productBsFeignProduct.deleteProduct(id);
    }
}
