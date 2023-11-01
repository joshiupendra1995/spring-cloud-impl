package com.productservice.model;

public record Product(Integer productId, String productName, Double price, String couponCode) {

   public  Product(Integer productId, String productName, Double price, String couponCode){
       this.productId = productId;
       this.productName = productName;
       this.price = price;
       this.couponCode = couponCode;
   }
}
