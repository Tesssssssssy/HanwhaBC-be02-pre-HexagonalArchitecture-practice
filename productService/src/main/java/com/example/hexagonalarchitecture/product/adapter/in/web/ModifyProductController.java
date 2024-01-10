package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalArchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.product.application.port.in.ModifyProductCommand;
import com.example.hexagonalarchitecture.product.application.port.in.ModifyProductUseCase;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyProductController {
    private final ModifyProductUseCase modifyProductUseCase;

    @PutMapping("/product/modify/{id}")
    Product modifyProduct(@RequestBody ModifyProductRequest request, @PathVariable Long id) {
        ModifyProductCommand command = ModifyProductCommand.builder()
                .name(request.getName())
                .contents(request.getContents())
                .price(request.getPrice())
                .build();

        return modifyProductUseCase.modifyProduct(command, id);
    }
}
