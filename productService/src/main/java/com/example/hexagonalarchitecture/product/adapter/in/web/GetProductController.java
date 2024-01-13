package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.product.application.port.in.GetProductUseCase;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetProductController {
    private final GetProductUseCase getProductUseCase;

    @RequestMapping(method = RequestMethod.GET, value = "/product/{productId}")
    public Product GetProductById(@PathVariable Long productId) {
        return getProductUseCase.getProduct(productId);
    }
}
