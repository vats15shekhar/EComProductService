package com.scaler.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductListResponseDTO {

    private List<ProductResponseDTO> product;

    public ProductListResponseDTO()
    {
        this.product = new ArrayList<>();
    }
}
