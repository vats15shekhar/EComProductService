package com.scaler.EcomProductService.service;


import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NormalProductService")
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequest) {
        return null;
    }

    @Override
    public Boolean deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id) {
        return null;
    }
}
