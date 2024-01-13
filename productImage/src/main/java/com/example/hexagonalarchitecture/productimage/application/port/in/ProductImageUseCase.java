package com.example.hexagonalarchitecture.productimage.application.port.in;

import com.example.hexagonalarchitecture.productimage.domain.ProductImage;

import java.util.List;

public interface ProductImageUseCase {
    List<ProductImage> registerProductImage(RegisterProductCommand command);

}
