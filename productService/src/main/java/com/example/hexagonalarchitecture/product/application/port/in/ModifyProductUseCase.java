package com.example.hexagonalarchitecture.product.application.port.in;

import com.example.hexagonalarchitecture.product.domain.Product;

public interface ModifyProductUseCase {
    Product modifyProduct(ModifyProductCommand command, Long id);
}
