package com.example.hexagonalarchitecture.productimage.adapter.out.persistence;

import com.example.hexagonalarchitecture.common.PersistenceAdapter;
import com.example.hexagonalarchitecture.productimage.application.port.out.GetProductImagePort;
import com.example.hexagonalarchitecture.productimage.application.port.out.ProductImagePort;
import com.example.hexagonalarchitecture.productimage.domain.ProductImage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductImagePersistenceAdapter implements ProductImagePort, GetProductImagePort {
    private final SpringDataProductRepository springDataProductRepository;

    @Override
    public ProductImage registerProductImage(ProductImage product) {
        ProductImageEntity productImageEntity = ProductImageEntity.builder()
                .productId(product.getProductId())
                .imagePath(product.getImagePath())
                .build();
        productImageEntity = springDataProductRepository.save(productImageEntity);
        return ProductImage.builder()
                .id(productImageEntity.getId())
                .productId(productImageEntity.getProductId())
                .imagePath(productImageEntity.getImagePath())
                .build();
    }

    @Override
    public List<ProductImageEntity> getProductImage(Long productId) {
        return springDataProductRepository.findAllByProductId(productId);
    }
}
