package com.jaume.springcloud.productservice.controllers;

import com.jaume.springcloud.productservice.model.Product;
import com.jaume.springcloud.productservice.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getCouponByCode()
    {
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product coupon)
    {
        return productRepository.save(coupon);
    }
}
