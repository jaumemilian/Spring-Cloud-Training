package com.jaume.springcloud.productservice.controllers;

import com.jaume.springcloud.productservice.dto.Coupon;
import com.jaume.springcloud.productservice.model.Product;
import com.jaume.springcloud.productservice.repositories.ProductRepository;
import com.jaume.springcloud.productservice.restclients.CouponClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final CouponClient couponClient;

    public ProductController(ProductRepository productRepository, CouponClient couponClient) {
        this.productRepository = productRepository;
        this.couponClient = couponClient;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product)
    {
        Coupon coupon = couponClient.getCouponByCode(product.getCouponCode());

        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));

        return productRepository.save(product);
    }
}
