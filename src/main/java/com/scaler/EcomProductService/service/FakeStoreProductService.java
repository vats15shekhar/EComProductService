package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {


    private RestTemplateBuilder restTemplateBuilder; //This is the part of the Spring web dependency

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;

    }
    @Override
    public ProductListResponseDTO getAllProducts() {

      /*  String productResponseList = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build(); // Build the object that will be interacting with the web and supporting http methods like GET, PUT, POST etc
        ResponseEntity<ProductListResponseDTO> productResponse;
        productResponse = restTemplate.getForEntity(productResponseList,ProductListResponseDTO.class);
        return productResponse.getBody();*/

        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {

        String productResponseList = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build(); // Build the object that will be interacting with the web and supporting http methods like GET, PUT, POST etc
        ResponseEntity<ProductResponseDTO> productResponse;
        productResponse = restTemplate.getForEntity(productResponseList,ProductResponseDTO.class);
        return productResponse.getBody();

    }

    @Override
    public Product createProduct(String product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id) {
        return null;
    }
}
