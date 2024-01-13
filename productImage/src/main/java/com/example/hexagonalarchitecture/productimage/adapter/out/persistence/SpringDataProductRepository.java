package com.example.hexagonalarchitecture.productimage.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataProductRepository extends JpaRepository<ProductImageEntity,Long> {
    List<ProductImageEntity> findAllByProductId(Long productId);
}
