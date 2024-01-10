package com.example.hexagonalarchitecture.product.application.port.in;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ModifyProductCommand {
    @NotNull
    private String name;

    @NotNull
    private String contents;

    @NotNull
    private Integer price;
}
