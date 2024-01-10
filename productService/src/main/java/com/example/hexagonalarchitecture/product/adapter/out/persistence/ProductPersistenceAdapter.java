package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import com.example.hexagonalArchitecture.common.PersistenceAdapter;
import com.example.hexagonalarchitecture.product.application.port.out.ModifyProductPort;
import com.example.hexagonalarchitecture.product.application.port.out.RegisterProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements RegisterProductPort, ModifyProductPort {
    private final SpringDataProductRepository productRepository;

    @Override
    public ProductJpaEntity createProduct(Product product) {
        return productRepository.save(
                ProductJpaEntity.builder()
                        .name(product.getName())
                        .contents(product.getContents())
                        .price(product.getPrice())
                        .build());
    }

    @Override
    public ProductJpaEntity modifyProduct(Product product, Long id) {
        Optional<ProductJpaEntity> result = productRepository.findById(id);
        if (result.isPresent()) {
            ProductJpaEntity productJpaEntity = result.get();
            productJpaEntity.setName(product.getName());
            productJpaEntity.setContents(product.getContents());
            productJpaEntity.setPrice(product.getPrice());

            productJpaEntity = productRepository.save(productJpaEntity);
            return productJpaEntity;
        }
        return null;
    }
}
