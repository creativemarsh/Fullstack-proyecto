package com.perfulandia.ms_db_product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.ms_db_product.model.dto.DTOProduct;
import com.perfulandia.ms_db_product.model.entities.entityProduct;
import com.perfulandia.ms_db_product.model.repositories.repositoryProduct;


@Service
public class serviceProduct {
    @Autowired
    repositoryProduct productoRepo;

    public DTOProduct TranslataEntityTOProduct(entityProduct product) {
        DTOProduct dtoProduct = new DTOProduct();
        dtoProduct.setId(product.getId_product());
        dtoProduct.setName_product(product.getName_product());
        dtoProduct.setDesc_product(product.getDesc_product());
        dtoProduct.setPrecio(product.getPrecio());
        return dtoProduct;
    }
    
    public entityProduct translateDTOToEntity(DTOProduct dtoProduct) {
        entityProduct product = new entityProduct();
        product.setId_product(dtoProduct.getId());
        product.setName_product(dtoProduct.getName_product());
        product.setDesc_product(dtoProduct.getDesc_product());
        product.setPrecio(dtoProduct.getPrecio());
        return product;
    }

    public DTOProduct getAllProducts() {
        List<entityProduct> listProducts = productoRepo.findAll();
        DTOProduct dtoProduct = new DTOProduct();
        for (entityProduct product : listProducts) {
            dtoProduct = TranslataEntityTOProduct(product);
        }
        return dtoProduct;
    }

    public DTOProduct getProductById(Long id) {
        Optional<entityProduct> product = productoRepo.findById(id);
        DTOProduct dtoProduct = null;
        if(product.isPresent()){
            dtoProduct = TranslataEntityTOProduct(product.get());
        }
        return dtoProduct;
    }

    public entityProduct saveProduct(DTOProduct dtoProduct) {
        entityProduct product = translateDTOToEntity(dtoProduct);
        return productoRepo.save(product);
    }
}
