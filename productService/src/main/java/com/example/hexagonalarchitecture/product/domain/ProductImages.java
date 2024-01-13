package com.example.hexagonalarchitecture.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@AllArgsConstructor
public class ProductImages {
    private final Long productId;
    private final MultipartFile[] files;
}


