package com.example.hexagonalarchitecture.productimage.adapter.in.web;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class RegisterProductImageRequest {
    private final MultipartFile[] files;
}
