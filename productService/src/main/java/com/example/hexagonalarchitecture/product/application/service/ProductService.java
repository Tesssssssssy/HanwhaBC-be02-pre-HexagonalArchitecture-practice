package com.example.hexagonalarchitecture.product.application.service;

import com.example.hexagonalarchitecture.common.UseCase;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.application.port.in.GetProductUseCase;
import com.example.hexagonalarchitecture.product.application.port.in.ProductInputPort;
import com.example.hexagonalarchitecture.product.application.port.in.RegisterProductCommand;
import com.example.hexagonalarchitecture.product.application.port.out.GetProductPort;
import com.example.hexagonalarchitecture.product.application.port.out.ProductOutputPort;
import com.example.hexagonalarchitecture.product.application.port.out.UploadProductImagePort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductImages;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ProductService implements ProductInputPort, GetProductUseCase {
    private final ProductOutputPort productOutputPort;
    private final UploadProductImagePort uploadProductImagePort;
    private final GetProductPort getProductPort;

    @Override
    public Product registerProduct(RegisterProductCommand command) {
        Product product = Product.builder()
                .brandId(command.getBrandId())
                .name(command.getName())
                .price(command.getPrice())
                .build();

        product = productOutputPort.createProduct(product);

        ProductImages productImages = ProductImages.builder()
                .productId(product.getId())
                .files(command.getFiles())
                .build();
        uploadProductImagePort.uploadProductImagePort(productImages);

        return product;
    }

    @Override
    public Product getProduct(Long id) {
        ProductEntity entity = getProductPort.getProduct(id);
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brandId(entity.getBrandId())
                .price(entity.getPrice())
                .build();
    }
}
