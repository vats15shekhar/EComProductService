package com.scaler.EcomProductService.controller;


import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

  //  @MockBean(name="productService")
   // private ProductService productService;

    private ProductService productService = mock(ProductService.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllProductsReturnEmptyListWhenNoProductsAvailable() throws Exception
    {
        ProductListResponseDTO emptyResponse = productService.getAllProducts();
        Mockito.when(productService.getAllProducts()).thenReturn(emptyResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/products")).andExpect(status().is(200)).andExpect(content().string("[]"));
    }

}
