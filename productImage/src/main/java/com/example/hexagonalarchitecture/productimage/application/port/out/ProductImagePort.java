package com.example.hexagonalarchitecture.productimage.application.port.out;

import com.example.hexagonalarchitecture.productimage.domain.ProductImage;

public interface ProductImagePort {
    ProductImage registerProductImage(ProductImage product);
}
