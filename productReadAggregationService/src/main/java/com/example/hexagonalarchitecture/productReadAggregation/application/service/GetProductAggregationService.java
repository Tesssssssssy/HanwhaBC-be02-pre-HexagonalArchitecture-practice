package com.example.hexagonalarchitecture.productReadAggregation.application.service;

import com.example.hexagonalarchitecture.common.UseCase;
import com.example.hexagonalarchitecture.productReadAggregation.application.port.in.GetProductAggregationUseCase;
import com.example.hexagonalarchitecture.productReadAggregation.application.port.out.GetProductImagePort;
import com.example.hexagonalarchitecture.productReadAggregation.application.port.out.GetProductPort;
import com.example.hexagonalarchitecture.productReadAggregation.domain.Product;
import com.example.hexagonalarchitecture.productReadAggregation.domain.ProductAggregation;
import com.example.hexagonalarchitecture.productReadAggregation.domain.ProductImage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetProductAggregationService implements GetProductAggregationUseCase {

    private final GetProductPort getProductPort;
    private final GetProductImagePort getProductImagePort;
    @Override
    public ProductAggregation getProductAggregation(Long id) {
        // product-service한테 상품 정보 조회
        Product product = getProductPort.getProductPort(id);

        // product-image-service한테 상품 이미지 정보 조회
        List<ProductImage> productImages = getProductImagePort.getProductImagePort(id);

        // 취합해서 응답;

        return ProductAggregation.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .images(productImages)
                .build();
    }
}
