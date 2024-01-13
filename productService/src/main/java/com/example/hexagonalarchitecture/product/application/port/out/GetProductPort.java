package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;

public interface GetProductPort {
    ProductEntity getProduct(Long id);
}
