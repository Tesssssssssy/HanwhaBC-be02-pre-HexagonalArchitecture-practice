package com.example.hexagonalarchitecture.product.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.product.application.port.in.ProductInputPort;
import com.example.hexagonalarchitecture.product.application.port.in.RegisterProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterProductController {

    private final ProductInputPort productInputPort;

    @RequestMapping(method = RequestMethod.POST, value = "/product/register")
    public ResponseEntity register(
            @RequestHeader(value = "X-Authorization-Id", required = true) Long id,
            @RequestPart(value = "product") RegisterProductRequest request,
            @RequestPart(value = "files") MultipartFile[] files) {
        RegisterProductCommand command = RegisterProductCommand.builder()
                .brandId(id)
                .name(request.getName())
                .price(request.getPrice())
                .files(files)
                .build();
        return ResponseEntity.ok().body(productInputPort.registerProduct(command));
    }
}

