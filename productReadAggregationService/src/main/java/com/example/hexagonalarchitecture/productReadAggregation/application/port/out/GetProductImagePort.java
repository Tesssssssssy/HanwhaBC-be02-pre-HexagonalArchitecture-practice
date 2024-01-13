package com.example.hexagonalarchitecture.productReadAggregation.application.port.out;

import com.example.hexagonalarchitecture.productReadAggregation.domain.ProductImage;

import java.util.List;

public interface GetProductImagePort {
    List<ProductImage> getProductImagePort(Long id);
}
