package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalArchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.product.application.port.in.RegisterProductCommand;
import com.example.hexagonalarchitecture.product.application.port.in.RegisterProductUseCase;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterProductController {
    private final RegisterProductUseCase registerProductUseCase;

    @PostMapping("/product/create")
    Product createMember(@RequestBody RegisterProductRequest request) {
        RegisterProductCommand command = RegisterProductCommand.builder()
                .name(request.getName())
                .contents(request.getContents())
                .price(request.getPrice())
                .build();

        return registerProductUseCase.createProduct(command);
    }
}
