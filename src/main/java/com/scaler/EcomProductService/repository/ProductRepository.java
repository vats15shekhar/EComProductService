package com.scaler.EcomProductService.repository;

import com.scaler.EcomProductService.model.Price;
import com.scaler.EcomProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    // Custom methods, that JPA cannot create on it's own. We can define them here and call them.

    Product findByTitle(String title);
    Product findByTitleAndDescription(String title, String description); // select * from Product where title = ? and description = ?
 /*   Product findByTitleOrDescription(String title, String description); // select * from Product where title = ? or description = ?
    Product findByPriceLessThanEqual(Price price); // <= price
    Product findByPriceLessThan(Price price); // < price
    Product findByPriceGreaterThanEqual(Price price); // >= price
    Product findByPriceGreaterThan(Price price); // > price
    Product findByPriceBetweenStartPriceAndEndPrice(Price startPrice, Price endPrice);*/





}
