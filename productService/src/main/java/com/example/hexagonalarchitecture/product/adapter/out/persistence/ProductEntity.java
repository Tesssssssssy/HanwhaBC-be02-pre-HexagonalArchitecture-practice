package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private String name;
    private String price;
}
