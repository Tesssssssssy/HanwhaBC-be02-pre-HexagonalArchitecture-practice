package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductJpaEntity;
import com.example.hexagonalarchitecture.product.domain.Product;

public interface ModifyProductPort {
    ProductJpaEntity modifyProduct(Product product,Long id);
}
