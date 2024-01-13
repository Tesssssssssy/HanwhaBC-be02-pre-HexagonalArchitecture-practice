package com.example.hexagonalarchitecture.productReadAggregation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ProductAggregation {
    private final Long id;
    private final Long brandId;
    private final String name;
    private final Integer price;

    private final List<ProductImage> images;



}
