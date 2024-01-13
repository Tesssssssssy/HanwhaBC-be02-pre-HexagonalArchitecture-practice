package com.example.hexagonalarchitecture.productReadAggregation.application.port.in;

import com.example.hexagonalarchitecture.productReadAggregation.domain.ProductAggregation;

public interface GetProductAggregationUseCase {
    ProductAggregation getProductAggregation(Long id);
}
