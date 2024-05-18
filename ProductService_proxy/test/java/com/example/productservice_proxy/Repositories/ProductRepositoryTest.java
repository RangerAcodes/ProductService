package com.example.productservice_proxy.Repositories;

import com.example.productservice_proxy.Models.Categories;
import com.example.productservice_proxy.Models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    void saveProductaAndCategories() {
        Categories categories = new Categories();
        categories.setName("Electronics");
        categories.setDescription("Electronics - Testing");
        categories = categoryRepo.save(categories);

        Product product = new Product();
        product.setTitle("Laptop");
        product.setDescription("Laptop");
        product.setCategory(categories);
        productRepository.save(product);

//        Categories categories1 = categoryRepo.findById(1);
//        List<Product> productList = categories1.getProductList();
        System.out.println("Debugging - Adit");

    }
    @Test
        //@Transactional
    void saveProductsAndCategory2() {
        Categories categories = new Categories();
        categories.setName("Fashion");
        categories.setDescription("Fashion");
        //categories = categoryRepo.save(categories);

        Product product = new Product();
        product.setTitle("Tshirt");
        product.setDescription("Tshirt");
        product.setCategory(categories);
        productRepository.save(product);

        //Categories categories1 = categoryRepo.findById(categories.getId()).get();
        //List<Product> productList = categories1.getProductList();
        System.out.println("Debug");

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductsAndCategory3() {
        Categories category = categoryRepo.findById(2L);

//        Product product = new Product();
//
//        product.setPrice(1012);
//        product.setImageUrl("hiii");
//        product.setCategory(category);
//        Product savedProduct = productRepo.save(product);
//
//        product = new Product();
//        product.setPrice(103);
//        product.setImageUrl("hiii");
//        product.setCategory(category);
//        productRepo.save(product);



    }
}