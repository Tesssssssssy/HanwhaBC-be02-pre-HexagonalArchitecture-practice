package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.domain.Product;

public interface ProductOutputPort {
    Product createProduct(Product product);
}
