package com.scaler.EcomProductService.controller;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import com.scaler.EcomProductService.service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@Getter
@Setter

public class ProductController {

    // Since we are injecting dependency via constructor and it will be immutable. We set it to final for extra precautions
    private final ProductService productService;
    @Autowired // Autowired is not required in Spring 4.x version onwards
    public ProductController( @Qualifier("NormalProductService") ProductService productService)
    {
        this.productService = productService;
    }

    /*Field Injection
    @Autowired
            @Qualifier("FakeStoreProductService")
    private ProductService productService; */
    //
    @GetMapping("/products")
    public ResponseEntity getAllProducts()
    {
        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    // If we want to get product by ID, then we simply put id inside {}, then use PathVariable annotation. That will inject the id into the parameter for the method
    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id) throws ProductNotFoundException
    {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
        /*

        // We are creating a dummy API here at the Controller level

        ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("IPhone 15 Pro");
        p1.setPrice(150000);
        p1.setCategory("Electronics");
        p1.setDescription("Expensive phone");
        p1.setImage("www.google.com/images/iphone");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Mac Book");
        p2.setPrice(200000);
        p2.setCategory("Electronics");
        p2.setDescription("Expensive laptop");
        p2.setImage("www.google.com/images/macbook");

        List<ProductResponseDTO> products = Arrays.asList(p1, p2);
        return ResponseEntity.ok(products);*/
    }

    @GetMapping("/products/title/{title}")
    public ResponseEntity getProductByTitle(@PathVariable("title") String title) throws ProductNotFoundException
    {
        ProductResponseDTO response = productService.getProductByTitle(title);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO responseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id) throws ProductNotFoundException
    {
        Boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
        /*
        // We are creating a dummy API here at the Controller level

        ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("IPhone 15 Pro");
        p1.setPrice(150000);
        p1.setCategory("Electronics");
        p1.setDescription("Expensive phone");
        p1.setImage("www.google.com/images/iphone");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Mac Book");
        p2.setPrice(200000);
        p2.setCategory("Electronics");
        p2.setDescription("Expensive laptop");
        p2.setImage("www.google.com/images/macbook");

        List<ProductResponseDTO> products = Arrays.asList(p1, p2);
        return ResponseEntity.ok(products);*/
    }

}
