package com.scaler.EcomProductService.Client;


import com.scaler.EcomProductService.dto.FakeStoreProductRequestDTO;
import com.scaler.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component

public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;

    private FakeStoreAPIClient( RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String createProductURL = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build(); // Build the object that will be interacting with the web and supporting http methods like GET, PUT, POST etc
        ResponseEntity<FakeStoreProductResponseDTO> productResponse;
        productResponse = restTemplate.postForEntity(createProductURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(UUID id){
        String getProductByUrlId = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(getProductByUrlId, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProducts = "https://fakestoreapi.com/products/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray =
                restTemplate.getForEntity(getAllProducts, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }

    public void deleteProduct(int id){
        String productDeleteURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteURL);
    }

}
