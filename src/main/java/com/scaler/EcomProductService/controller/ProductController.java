package com.scaler.EcomProductService.controller;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Getter
@Setter

public class ProductController {

    @Autowired
            @Qualifier("FakeStoreProductService")
    ProductService productService;

    @GetMapping("/products/1")

    public ResponseEntity getProductById()
    {
        ProductResponseDTO response = productService.getProductById(1);
        return ResponseEntity.ok(response);


        /* ProductResponseDTO p1 = new ProductResponseDTO();
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
