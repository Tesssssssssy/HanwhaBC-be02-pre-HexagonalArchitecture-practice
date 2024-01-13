package com.example.hexagonalarchitecture.productimage.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
public class RegisterProductCommand {
    private final Long productId;
    private final MultipartFile[] files;
}
