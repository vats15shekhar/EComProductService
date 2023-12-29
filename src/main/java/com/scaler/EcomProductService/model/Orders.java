package com.scaler.EcomProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity(name ="ECOM_ORDER")
public class Orders extends BaseModel{
  private double price;

 //In @ManyToMany mapping, if we have this annotation on both Orders and Products class,
 // then there will be two mapping tables, we do no want that. Hence we use mappedBy to create just one mapping table
 @ManyToMany(mappedBy = "orderList")
 List<Product> products;

}
