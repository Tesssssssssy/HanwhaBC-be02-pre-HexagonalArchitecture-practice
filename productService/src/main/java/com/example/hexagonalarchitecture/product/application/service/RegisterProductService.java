package com.example.hexagonalarchitecture.product.application.service;

import com.example.hexagonalArchitecture.common.UseCase;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductJpaEntity;
import com.example.hexagonalarchitecture.product.application.port.in.RegisterProductCommand;
import com.example.hexagonalarchitecture.product.application.port.in.RegisterProductUseCase;
import com.example.hexagonalarchitecture.product.application.port.out.RegisterProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterProductService implements RegisterProductUseCase {
    private final RegisterProductPort registerProductPort;

    @Override
    public Product createProduct(RegisterProductCommand command) {
        Product product = Product.builder()
                .name(command.getName())
                .contents(command.getContents())
                .price(command.getPrice())
                .build();

        ProductJpaEntity productJpaEntity = registerProductPort.createProduct(product);

        return Product.builder()
                .id(productJpaEntity.getId())
                .name(productJpaEntity.getName())
                .contents(productJpaEntity.getContents())
                .price(productJpaEntity.getPrice())
                .build();
    }
}
