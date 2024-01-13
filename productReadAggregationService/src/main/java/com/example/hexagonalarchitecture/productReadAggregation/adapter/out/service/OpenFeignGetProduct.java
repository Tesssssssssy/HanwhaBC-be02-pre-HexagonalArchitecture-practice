package com.example.hexagonalarchitecture.productReadAggregation.adapter.out.service;

import com.example.hexagonalarchitecture.productReadAggregation.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Product", url = "http://localhost:8083/product")
public interface OpenFeignGetProduct {

    @GetMapping(value = "/{productId}")
    Product call(@PathVariable Long productId);
}
