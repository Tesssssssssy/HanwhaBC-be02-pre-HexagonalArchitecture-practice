package com.example.hexagonalarchitecture.product.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
public class RegisterProductCommand {
    private final Long brandId;
    private final String name;
    private final String price;
    private final MultipartFile[] files;

    public RegisterProductCommand(Long brandId, String name, String price, MultipartFile[] files) {
        this.brandId = brandId;
        this.name = name;
        this.price = price;
        this.files = files;
    }
}
