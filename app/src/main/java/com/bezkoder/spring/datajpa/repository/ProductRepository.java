package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findAllByProductNameContains(String productName);
}
