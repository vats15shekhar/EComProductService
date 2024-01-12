package com.scaler.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    public String title;
    public double price;
    public String category;
    public String description;
    public String image;
}
