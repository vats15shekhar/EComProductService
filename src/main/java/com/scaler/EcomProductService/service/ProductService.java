package com.scaler.EcomProductService.service;


import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import com.scaler.EcomProductService.model.Product;

import java.util.UUID;

public interface ProductService {

    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO productRequest);

    Boolean deleteProduct(int id) throws ProductNotFoundException;
    Product updateProduct(int id);

    ProductResponseDTO getProductByTitle(String title) throws ProductNotFoundException;

    ProductResponseDTO getProductByTitleAndDescription(String title, String description);


}
