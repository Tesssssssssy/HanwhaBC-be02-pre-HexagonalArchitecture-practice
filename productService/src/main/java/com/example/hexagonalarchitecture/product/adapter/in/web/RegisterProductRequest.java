package com.example.hexagonalarchitecture.product.adapter.in.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterProductRequest {
    private final String name;
    private final String price;
}
