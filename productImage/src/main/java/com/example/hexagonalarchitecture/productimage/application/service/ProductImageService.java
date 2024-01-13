package com.example.hexagonalarchitecture.productimage.application.service;

import com.example.hexagonalarchitecture.common.UseCase;
import com.example.hexagonalarchitecture.productimage.application.port.in.ProductImageUseCase;
import com.example.hexagonalarchitecture.productimage.application.port.in.RegisterProductCommand;
import com.example.hexagonalarchitecture.productimage.application.port.out.ProductImagePort;
import com.example.hexagonalarchitecture.productimage.application.port.out.ProductImageUploadPort;
import com.example.hexagonalarchitecture.productimage.domain.ProductImage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ProductImageService implements ProductImageUseCase {
    private final ProductImagePort productImagePort;
    private final ProductImageUploadPort productImageUploadPort;

    @Override
    public List<ProductImage> registerProductImage(RegisterProductCommand command) {
        List<ProductImage> productImages = new ArrayList<>();
        for (MultipartFile file : command.getFiles()) {
            String imagePath = productImageUploadPort.uploadProductImage(file);
            ProductImage productImage = ProductImage.builder()
                    .productId(command.getProductId())
                    .imagePath(imagePath)
                    .build();
            productImage = productImagePort.registerProductImage(productImage);
            productImages.add(productImage);
        }

        return productImages;
    }
}
