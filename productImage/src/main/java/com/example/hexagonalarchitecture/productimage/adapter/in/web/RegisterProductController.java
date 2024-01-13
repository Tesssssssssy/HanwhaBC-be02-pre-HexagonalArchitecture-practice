package com.example.hexagonalarchitecture.productimage.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.productimage.application.port.in.ProductImageUseCase;
import com.example.hexagonalarchitecture.productimage.application.port.in.RegisterProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterProductController {

    private final ProductImageUseCase productInputPort;

    @RequestMapping(method = RequestMethod.POST, value = "/productimage/upload/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity registerProductImage(@PathVariable Long productId, @RequestPart("files") MultipartFile[] files) {

        RegisterProductCommand command = RegisterProductCommand.builder()
                .productId(productId)
                .files(files)
                .build();
        return ResponseEntity.ok().body(productInputPort.registerProductImage(command));
    }
}
