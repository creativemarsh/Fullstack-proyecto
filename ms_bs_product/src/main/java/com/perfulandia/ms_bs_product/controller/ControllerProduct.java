package main.java.com.perfulandia.ms_bs_product.controller;
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

import com.perfulandia.ms_bs_product.model.DTO.DTOProduct;
import com.perfulandia.ms_bs_product.service.ServiceProduct;


@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ControllerProduct {

    @Autowired
    private ServiceProduct serviceProduct;

    @GetMapping("")
    public ResponseEntity<List<DTOProduct>> getAllProducts() {
        List<DTOProduct> products = serviceProduct.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOProduct> getProductById(@PathVariable("id") Long id) {
        DTOProduct product = serviceProduct.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("")
    public ResponseEntity<DTOProduct> saveProduct(@RequestBody DTOProduct dtoProduct) {
        DTOProduct savedProduct = serviceProduct.saveProduct(dtoProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOProduct> updateProduct(@PathVariable("id") Long id, @RequestBody DTOProduct dtoProduct) {
        DTOProduct updatedProduct = serviceProduct.updateProduct(id, dtoProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        serviceProduct.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
