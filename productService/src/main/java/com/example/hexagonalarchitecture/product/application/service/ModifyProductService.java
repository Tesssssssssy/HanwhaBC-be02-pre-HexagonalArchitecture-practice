package com.example.hexagonalarchitecture.product.application.service;

import com.example.hexagonalArchitecture.common.UseCase;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductJpaEntity;
import com.example.hexagonalarchitecture.product.application.port.in.ModifyProductCommand;
import com.example.hexagonalarchitecture.product.application.port.in.ModifyProductUseCase;
import com.example.hexagonalarchitecture.product.application.port.out.ModifyProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ModifyProductService implements ModifyProductUseCase {
    private final ModifyProductPort modifyProductPort;


    @Override
    public Product modifyProduct(ModifyProductCommand command, Long id) {
        Product product = Product.builder()
                .name(command.getName())
                .contents(command.getContents())
                .price(command.getPrice())
                .build();

        ProductJpaEntity productJpaEntity = modifyProductPort.modifyProduct(product, id);

        return Product.builder()
                .id(productJpaEntity.getId())
                .name(productJpaEntity.getName())
                .contents(productJpaEntity.getContents())
                .price(productJpaEntity.getPrice())
                .build();
    }
}
