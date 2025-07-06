package com.perfulandia.ms_bs_product.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.perfulandia.ms_bs_product.client.ProductBsFeignProduct;
import com.perfulandia.ms_bs_product.model.DTO.DTOProduct;

class ServiceProductTest {

    @Mock
    private ProductBsFeignProduct productBsFeignProduct;

    @InjectMocks
    private ServiceProduct serviceProduct; 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
    
        List<DTOProduct> expectedProducts = List.of(
            new DTOProduct(1L, "Producto 1", "Desc 1", 100000L),
            new DTOProduct(2L, "Producto 2", "Desc 2", 200000L)
        );
    
        when(productBsFeignProduct.getAllProducts()).thenReturn(ResponseEntity.ok(expectedProducts));

    
        List<DTOProduct> actualProducts = serviceProduct.getAllProducts();

    
        assertNotNull(actualProducts);
        assertEquals(2, actualProducts.size());
        assertEquals("Producto 1", actualProducts.get(0).getName_product());

    
        verify(productBsFeignProduct, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() {
        Long productId = 1L;
        DTOProduct expectedProduct = new DTOProduct(productId, "Producto 1", "Desc 1", 100000L);

        when(productBsFeignProduct.getProductById(productId)).thenReturn(ResponseEntity.ok(expectedProduct));

        DTOProduct actualProduct = serviceProduct.getProductById(productId);

        assertNotNull(actualProduct);
        assertEquals(productId, actualProduct.getId());
        assertEquals("Producto 1", actualProduct.getName_product());

        verify(productBsFeignProduct, times(1)).getProductById(productId);
    }
    
    @Test
    void testSaveProduct() {
        DTOProduct productToSave = new DTOProduct(null, "Nuevo Producto", "Nueva Desc", 300000L);
        DTOProduct savedProduct = new DTOProduct(3L, "Nuevo Producto", "Nueva Desc", 300000L);

        when(productBsFeignProduct.saveProduct(productToSave)).thenReturn(ResponseEntity.ok(savedProduct));

        DTOProduct actualSavedProduct = serviceProduct.saveProduct(productToSave);

        assertNotNull(actualSavedProduct);
        assertEquals(3L, actualSavedProduct.getId());
        assertEquals("Nuevo Producto", actualSavedProduct.getName_product());

        verify(productBsFeignProduct, times(1)).saveProduct(productToSave);
    }

    @Test
    void testUpdateProduct() {
        Long productId = 1L;
        DTOProduct productToUpdate = new DTOProduct(productId, "Producto Actualizado", "Desc Actualizada", 150000L);

        when(productBsFeignProduct.updateProduct(productId, productToUpdate)).thenReturn(ResponseEntity.ok(productToUpdate));

        DTOProduct actualUpdatedProduct = serviceProduct.updateProduct(productId, productToUpdate);

        assertNotNull(actualUpdatedProduct);
        assertEquals(productId, actualUpdatedProduct.getId());
        assertEquals("Producto Actualizado", actualUpdatedProduct.getName_product());

        verify(productBsFeignProduct, times(1)).updateProduct(productId, productToUpdate);
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        serviceProduct.deleteProduct(productId);

        verify(productBsFeignProduct, times(1)).deleteProduct(productId);
    }
    
}
