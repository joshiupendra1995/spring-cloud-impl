package com.couponservice.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coupon")
public class CouponController {

    Map<String,Integer> map = new LinkedHashMap<>();


    @PostConstruct
    public void loadCoupons(){
        map.put("UJ001",100);
        map.put("JK121",500);
    }


    @GetMapping("/apply-coupon/{couponCode}")
    public Integer couponApplied(@PathVariable String couponCode){
        if(map.containsKey(couponCode))
           return map.get(couponCode);
        throw new RuntimeException("Coupon code applied "+ couponCode + " is invalid");
    }
}
