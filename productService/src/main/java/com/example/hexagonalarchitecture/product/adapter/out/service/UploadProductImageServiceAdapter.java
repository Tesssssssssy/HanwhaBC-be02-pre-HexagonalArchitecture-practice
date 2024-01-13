package com.example.hexagonalarchitecture.product.adapter.out.service;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.product.application.port.out.UploadProductImagePort;
import com.example.hexagonalarchitecture.product.domain.ProductImages;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UploadProductImageServiceAdapter implements UploadProductImagePort {
    private final OpenFeignUploadProductImage openFeignUploadProductImage;

    @Override
    public void uploadProductImagePort(ProductImages productImages) {
        try {
            openFeignUploadProductImage.call(productImages.getProductId(), productImages.getFiles());
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
