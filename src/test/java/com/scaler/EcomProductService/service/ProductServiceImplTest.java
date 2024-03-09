package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.exception.InvalidTitleException;
import com.scaler.EcomProductService.exception.ProductNotFoundException;
import com.scaler.EcomProductService.model.Category;
import com.scaler.EcomProductService.model.Price;
import com.scaler.EcomProductService.model.Product;
import com.scaler.EcomProductService.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock // we need a mock object of the given attribute
    private ProductRepository productRepository;

    @InjectMocks // this is the class we want to test, and this is where we would inject the mock objects
    private ProductServiceImpl productServiceImpl;


    @BeforeEach
    public void setup()
    {
        System.out.println("Hello from before each method");
        MockitoAnnotations.openMocks(this); // creates auto closeable resources for each test method
    }

     // This method is to test all the success scenarios
    @Test
    public void testFindProductByTitleSuccess() throws ProductNotFoundException {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = "TestTitle";
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);
        // The use of any() will return the mock product no matter what we pass as the parameter. But it should not pass. Which is why, instead of any() we will pass the title.
        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);
        //Act
        ProductResponseDTO actualResponse = productServiceImpl.getProductByTitle(testTitle);
        //Assert
        Assertions.assertEquals(actualResponse.getTitle(), mockProduct.getTitle());
        Assertions.assertEquals(actualResponse.getDescription(), mockProduct.getDescription());
        Assertions.assertEquals(actualResponse.getId(), mockProduct.getId());
        Assertions.assertEquals(actualResponse.getPrice(), mockProduct.getPrice().getAmount());
        Assertions.assertEquals(actualResponse.getCategory(), mockProduct.getCategory().getCategoryName());
    }


    // This method is to test the scenario when the repository object returns a blank

    @Test
    public void testFindByProductByTitle_RepoRespondsWithNullObject() throws ProductNotFoundException {
        //Arrange
        String testTitle = "testProductTitle";
        when(productRepository.findByTitle(testTitle)).thenReturn(null);
        //ProductResponseDTO actualResponse = productServiceImpl.getProductByTitle(testTitle);
        // This method is to test the failure scenario. whenever the findByTitle() method is called, there will be an exception thrown, because we will pass a null object P inside the mapper,
        // Assertions.assertEquals(actualResponse.getTitle(), testTitle);
        // We want to throw an exception whenever the repo returns a null. The below will throw an exception on calling of productServiceImpl.getProductByTitle(testTitle)
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getProductByTitle(testTitle));
    }


    // This method tests for a blank title. If there is a blank title we want to look for. Then how we will handle it
   @Test
    public void testFindProductByTitle_NullTitle() throws ProductNotFoundException {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = null;
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);
        //Assert and Act
        Assertions.assertThrows(InvalidTitleException.class, () -> productServiceImpl.getProductByTitle(testTitle));
    }

}
