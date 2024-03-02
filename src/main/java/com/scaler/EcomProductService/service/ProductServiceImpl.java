package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import com.scaler.EcomProductService.mapper.ProductMapper;
import com.scaler.EcomProductService.model.Product;
import com.scaler.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("NormalProductService")
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {

        List<Product> products = productRepository.findAll();
        ProductListResponseDTO productResponseDTO = ProductMapper.convertProductsToProductResponseDTO(products);
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(UUID id) throws ProductNotFoundException{
       /* Optional<Product> product= productRepository.findById(id);
        if(isNull(product)){
            throw new ProductNotFoundException("Product not found with id : " + id);
        }

        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);*/

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

    // These are all custom methods that we are adding in order to perform a certain operation that JPA does not internally provide
    @Override
    public ProductResponseDTO getProductByTitle(String title) throws ProductNotFoundException {

        Product product = productRepository.findByTitle(title);

        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }

    public ProductResponseDTO getProductByTitleAndDescription(String title, String description)
    {
        Product product = productRepository.findByTitleAndDescription(title, description);

        ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
        return productResponseDTO;
    }
}
