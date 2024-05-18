package com.example.productservice_proxy.Controllers;

import com.example.productservice_proxy.Models.Product;
import com.example.productservice_proxy.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @MockBean
    IProductService productService;

    @Autowired
    ProductController productController;

    @Test
    void test_whenGetProductIsCalled_ReturnProducts(){
        Product product = new Product();
        product.setId(3l);
        product.setTitle("test");
        when(productService.getSingleProduct(any(Long.class))).thenReturn(product);
        ResponseEntity<Product> productResponseEntity = productController.getSingleProduct(2l);
        assertNotNull(productResponseEntity);
        assertEquals("test", productResponseEntity.getBody().getTitle());

    }

    @Test
    void test_whenGetProductIsCalled_ReturnException(){
        Product product = new Product();
        when(productService.getSingleProduct(any(Long.class))).
                thenThrow(new RuntimeException("Something is Wrong"));

        assertThrows(RuntimeException.class, () ->
            productController.getSingleProduct(20l));
    }
}