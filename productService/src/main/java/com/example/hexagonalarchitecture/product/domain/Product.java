package com.example.hexagonalarchitecture.product.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private final Long id;
    private final String name;
    private final String contents;
    private final Integer price;
}
