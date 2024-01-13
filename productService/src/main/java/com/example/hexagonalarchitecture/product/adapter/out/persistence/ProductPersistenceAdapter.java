package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import com.example.hexagonalarchitecture.common.PersistenceAdapter;
import com.example.hexagonalarchitecture.product.application.port.out.GetProductPort;
import com.example.hexagonalarchitecture.product.application.port.out.ProductOutputPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort, GetProductPort {
    private final SpringDataProductRepository springDataProductRepository;

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .brandId(product.getBrandId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
        productEntity = springDataProductRepository.save(productEntity);
        return Product.builder()
                .id(productEntity.getId())
                .brandId(productEntity.getBrandId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }

    @Override
    public ProductEntity getProduct(Long id) {
        Optional<ProductEntity> result =springDataProductRepository.findById(id);
        if (result.isPresent()) {
            return  result.get();
        }
        return null;
    }
}
