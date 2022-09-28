package com.jaume.springcloud.couponservice.controllers;


import com.jaume.springcloud.couponservice.model.Coupon;
import com.jaume.springcloud.couponservice.repositories.CouponRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/coupons")
public class CouponController {

    private final CouponRepository couponRepository;

    public CouponController(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Coupon> getCouponByCode()
    {
        return couponRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Coupon create(@RequestBody Coupon coupon)
    {
        return couponRepository.save(coupon);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Coupon getCouponByCode(@PathVariable("code") String code)
    {
        return couponRepository.findByCode(code);
    }
}
