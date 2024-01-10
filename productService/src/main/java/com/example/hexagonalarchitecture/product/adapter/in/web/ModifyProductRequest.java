package com.example.hexagonalarchitecture.product.adapter.in.web;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ModifyProductRequest {
    @NotNull
    private String name;

    @NotNull
    private String contents;

    @NotNull
    private Integer price;
}
