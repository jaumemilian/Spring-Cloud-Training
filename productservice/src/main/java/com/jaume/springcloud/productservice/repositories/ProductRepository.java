package com.jaume.springcloud.productservice.repositories;

import com.jaume.springcloud.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
