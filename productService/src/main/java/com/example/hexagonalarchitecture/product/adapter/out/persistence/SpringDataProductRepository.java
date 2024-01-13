package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity,Long> {
}
