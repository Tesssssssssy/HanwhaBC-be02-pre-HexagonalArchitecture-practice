package com.example.hexagonalarchitecture.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Product {
    private final Long id;
    private final Long brandId;
    private final String name;
    private final String price;
}
