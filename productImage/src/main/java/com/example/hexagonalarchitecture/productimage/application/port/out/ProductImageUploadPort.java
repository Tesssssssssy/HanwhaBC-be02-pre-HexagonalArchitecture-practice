package com.example.hexagonalarchitecture.productimage.application.port.out;

import org.springframework.web.multipart.MultipartFile;

public interface ProductImageUploadPort {
    String uploadProductImage(MultipartFile file);
}
