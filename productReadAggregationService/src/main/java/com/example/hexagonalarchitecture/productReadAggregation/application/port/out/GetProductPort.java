package com.example.hexagonalarchitecture.productReadAggregation.application.port.out;

import com.example.hexagonalarchitecture.productReadAggregation.domain.Product;

public interface GetProductPort {
    Product getProductPort(Long id);
}
