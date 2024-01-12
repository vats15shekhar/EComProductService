package com.scaler.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {

    public UUID id;
    public String title;
    public double price;
    public String category;
    public String description;
    public String image;
}
