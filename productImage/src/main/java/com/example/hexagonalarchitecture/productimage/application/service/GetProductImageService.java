package com.example.hexagonalarchitecture.productimage.application.service;

import com.example.hexagonalarchitecture.common.UseCase;
import com.example.hexagonalarchitecture.productimage.adapter.out.persistence.ProductImageEntity;
import com.example.hexagonalarchitecture.productimage.application.port.in.GetProductImageUseCase;
import com.example.hexagonalarchitecture.productimage.application.port.out.GetProductImagePort;
import com.example.hexagonalarchitecture.productimage.domain.ProductImage;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetProductImageService implements GetProductImageUseCase {
    private final GetProductImagePort getProductImagePort;

    @Override
    public List<ProductImage> getProductImage(Long productId) {
        List<ProductImageEntity> entities = getProductImagePort.getProductImage(productId);
        List<ProductImage> productImages = new ArrayList<>();
        for (ProductImageEntity entity : entities) {
            productImages.add(
                    ProductImage.builder()
                            .id(entity.getId())
                            .imagePath(entity.getImagePath())
                            .build()
            );
        }

        return productImages;
    }
}
