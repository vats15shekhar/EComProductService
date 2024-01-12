package com.scaler.EcomProductService.model;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String categoryName;

    // In this scenario, if we only do @OnetoMany, then a mapping table is created which we do not want.
    // In order to avoid that we are using @JoinColumn, which is telling JPA to create a join using the column category_id
    // and not create a mapping table. The convention to mention the column name is tablename_columnname.
    // In this case it is category_id
    @OneToMany(mappedBy = "category")
    //@JoinColumn(name = "category_id")
    List<Product> productList;
}
