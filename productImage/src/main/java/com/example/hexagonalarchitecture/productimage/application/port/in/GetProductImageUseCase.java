package com.example.hexagonalarchitecture.productimage.application.port.in;

import com.example.hexagonalarchitecture.productimage.domain.ProductImage;

import java.util.List;

public interface GetProductImageUseCase {
    List<ProductImage> getProductImage(Long productId);
}
