package com.example.hexagonalarchitecture.productReadAggregation.adapter.out.service;

import com.example.hexagonalarchitecture.productReadAggregation.domain.ProductImage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ProductImage", url = "http://localhost:8084/productimage")
public interface OpenFeignGetProductImages {

    @GetMapping(value = "/{productId}")
    List<ProductImage> call(@PathVariable Long productId);
}
