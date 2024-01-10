package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductJpaEntity;
import com.example.hexagonalarchitecture.product.domain.Product;

public interface RegisterProductPort {
    ProductJpaEntity createProduct(Product product);
}
