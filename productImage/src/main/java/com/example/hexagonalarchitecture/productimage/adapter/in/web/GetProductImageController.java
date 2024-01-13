package com.example.hexagonalarchitecture.productimage.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.productimage.application.port.in.GetProductImageUseCase;
import com.example.hexagonalarchitecture.productimage.domain.ProductImage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetProductImageController {
    private final GetProductImageUseCase getProductImageUseCase;
    @RequestMapping(method = RequestMethod.GET, value = "/productimage/{productId}")
    List<ProductImage> getProductImage(@PathVariable Long productId) {
        return getProductImageUseCase.getProductImage(productId);
    }
}
