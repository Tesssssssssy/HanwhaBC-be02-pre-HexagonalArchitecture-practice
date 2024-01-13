package com.example.hexagonalarchitecture.productimage.application.port.out;

import com.example.hexagonalarchitecture.productimage.adapter.out.persistence.ProductImageEntity;

import java.util.List;

public interface GetProductImagePort {
    List<ProductImageEntity> getProductImage(Long productId);
}
