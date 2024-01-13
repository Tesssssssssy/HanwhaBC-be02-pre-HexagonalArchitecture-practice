package com.example.hexagonalarchitecture.productReadAggregation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ProductImage {
    private final Long id;
    private final Long productId;
    private final String imagePath;
}
