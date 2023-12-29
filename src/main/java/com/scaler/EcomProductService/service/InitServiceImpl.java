package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.model.Category;
import com.scaler.EcomProductService.model.Orders;
import com.scaler.EcomProductService.model.Price;
import com.scaler.EcomProductService.model.Product;
import com.scaler.EcomProductService.repository.CategoryRepository;
import com.scaler.EcomProductService.repository.OrdersRepository;
import com.scaler.EcomProductService.repository.PriceRepository;
import com.scaler.EcomProductService.repository.ProductRepository;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{

    OrdersRepository ordersRepository;
    PriceRepository priceRepository;
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public InitServiceImpl(OrdersRepository ordersRepository, PriceRepository priceRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.ordersRepository = ordersRepository;
        this.priceRepository = priceRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialize()
     {
           Category electronics = new Category();
           electronics.setCategoryName("Electronics");
           categoryRepository.save(electronics);

           Price watchPrice = new Price();
           watchPrice.setCurrency("INR");
           watchPrice.setAmount(50000);
           watchPrice.setDiscount(0);

           Price phonePrice = new Price();
           phonePrice.setCurrency("INR");
           phonePrice.setAmount(100000);
           phonePrice.setDiscount(0);

           Price laptopPrice = new Price();
           laptopPrice.setCurrency("INR");
           laptopPrice.setAmount(200000);
           laptopPrice.setDiscount(0);

            priceRepository.save(watchPrice);
            priceRepository.save(phonePrice);
            priceRepository.save(laptopPrice);


           Product watch = new Product();
           watch.setTitle("Apple Watch");
           watch.setDescription("Expensive watch");
           watch.setImage("Some Image");
           watch.setPrice(watchPrice);
           watch.setCategory(electronics);

           Product phone = new Product();
           phone.setTitle("IPhone");
           phone.setDescription("Expensive phone");
           phone.setImage("Some Image of IPhone");
           phone.setPrice(phonePrice);
           phone.setCategory(electronics);

           Product laptop = new Product();
           laptop.setTitle("MAC");
           laptop.setDescription("Expensive laptop");
           laptop.setImage("Some Image of MAC laptop");
           laptop.setPrice(laptopPrice);
           laptop.setCategory(electronics);

           productRepository.save(watch);
           productRepository.save(phone);
           productRepository.save(laptop);

           Orders order = new Orders();
           order.setProducts(List.of(watch,phone,laptop));
           ordersRepository.save(order);

     }
}
