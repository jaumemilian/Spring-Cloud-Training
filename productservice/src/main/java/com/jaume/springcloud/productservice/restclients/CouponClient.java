package com.jaume.springcloud.productservice.restclients;

import com.jaume.springcloud.productservice.dto.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COUPON-SERVICE")
public interface CouponClient {

    @GetMapping("/coupons/{code}")
    Coupon getCouponByCode(@PathVariable("code") String code);
}
