package com.perfulandia.ms_bs_product.controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.perfulandia.ms_bs_product.model.DTO.DTOProduct;
import com.perfulandia.ms_bs_product.service.ServiceProduct;


class ControllerProductTest {

    @Mock
    private ServiceProduct serviceProduct;

    @InjectMocks
    private ControllerProduct controllerProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @SuppressWarnings("null")
    @Test
    void testGetAllProducts() {
        List<DTOProduct> products = List.of(
            new DTOProduct(1L, "null", "null", 100000L),
            new DTOProduct(2L, "null", "null", 200000L)
        );

        when(serviceProduct.getAllProducts()).thenReturn(products);
        ResponseEntity<List<DTOProduct>> result = controllerProduct.getAllProducts();

        assertNotNull(result);
        assertEquals(products.get(0).getId(), result.getBody().get(0).getId());
        assertEquals(products.get(0).getName_product(), result.getBody().get(0).getName_product());
        assertEquals(products.get(0).getDesc_product(), result.getBody().get(0).getDesc_product());
        assertEquals(products.get(0).getPrecio(), result.getBody().get(0).getPrecio());
        assertEquals(products.get(1).getId(), result.getBody().get(1).getId());
        assertEquals(products.get(1).getName_product(), result.getBody().get(1).getName_product());
        assertEquals(products.get(1).getDesc_product(), result.getBody().get(1).getDesc_product());
        assertEquals(products.get(1).getPrecio(), result.getBody().get(1).getPrecio()); 
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(serviceProduct, times(1)).getAllProducts();
        
    }

    @SuppressWarnings("null")
    @Test
    void testGetProductById() {
        
        List<DTOProduct> products = List.of(
            new DTOProduct(1L, "null", "null", 100000L),
            new DTOProduct(2L, "null", "null", 200000L)
        );


        when(serviceProduct.getProductById(1L)).thenReturn(products.get(0));
        ResponseEntity<DTOProduct> response = controllerProduct.getProductById(1L);

        assertNotNull(response);
        assertEquals(products.get(0).getId(), response.getBody().getId());
        assertEquals(products.get(0).getName_product(), response.getBody().getName_product());
        assertEquals(products.get(0).getDesc_product(), response.getBody().getDesc_product());
        assertEquals(products.get(0).getPrecio(), response.getBody().getPrecio());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(serviceProduct, times(1)).getProductById(1L);
    }

    @Test
    void testSaveProduct() {
        
        DTOProduct products = new DTOProduct(1L, "null", "null", 100000L);

        when(serviceProduct.saveProduct(any(DTOProduct.class))).thenReturn(products);

        
        ResponseEntity<DTOProduct> response = controllerProduct.saveProduct(products);

        
        assertNotNull(response);
        assertEquals(products, response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(serviceProduct, times(1)).saveProduct(products);        
    }

    @SuppressWarnings("null")
    @Test
    void testUpdateProduct() {

        Long productId = 1L;

        DTOProduct productDataForUpdate = new DTOProduct(1L, "Producto Actualizado", "Descripción Nueva", 100000L);

        DTOProduct expectedProductAfterUpdate = new DTOProduct(1L, "Producto Actualizado", "Descripción Nueva", 200000L);

        when(serviceProduct.updateProduct(eq(productId), any(DTOProduct.class))).thenReturn(expectedProductAfterUpdate);

        ResponseEntity<DTOProduct> response = controllerProduct.updateProduct(productId, productDataForUpdate);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());



        DTOProduct actualProduct = response.getBody();
        assertEquals(expectedProductAfterUpdate.getId(), actualProduct.getId());
        assertEquals(expectedProductAfterUpdate.getName_product(), actualProduct.getName_product());
        assertEquals(expectedProductAfterUpdate.getDesc_product(), actualProduct.getDesc_product());
        assertEquals(expectedProductAfterUpdate.getPrecio(), actualProduct.getPrecio());


        verify(serviceProduct, times(1)).updateProduct(eq(productId), any(DTOProduct.class));
    }

    @Test
    void testDeleteProduct() {
        // Arrange
        Long productId = 1L;
        doNothing().when(serviceProduct).deleteProduct(productId);

        // Act
        ResponseEntity<Void> response = controllerProduct.deleteProduct(productId);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(serviceProduct, times(1)).deleteProduct(productId);
    }
}