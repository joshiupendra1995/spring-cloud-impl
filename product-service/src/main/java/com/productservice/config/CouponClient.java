package com.productservice.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cloud-gateway-service")
//@RibbonClient("coupon-service")
public interface CouponClient {

    @GetMapping("/v1/coupon/apply-coupon/{couponCode}")
    Integer applyCoupon(@PathVariable String couponCode);

}
