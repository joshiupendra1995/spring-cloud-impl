package com.productservice.controller;

import com.productservice.config.CouponClient;
import com.productservice.model.Product;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.random.RandomGenerator;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private CouponClient couponClient;

    @PostMapping("/place-order")
    @Retry(name="place-order-api", fallbackMethod = "handleFailure")
    public Product placeOrder(@RequestBody Product product){
        int finalPrice = product.price().intValue() - couponClient.applyCoupon(product.couponCode());
        return  new Product(RandomGenerator.getDefault().nextInt(),product.productName(), (double) finalPrice,product.couponCode());
    }

    public Product handleFailure(Product product , Exception exception){
        return product;
    }
}
