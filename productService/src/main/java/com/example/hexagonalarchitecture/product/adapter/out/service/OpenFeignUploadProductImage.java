package com.example.hexagonalarchitecture.product.adapter.out.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "ProductImage", url = "http://localhost:8084/productimage")
public interface OpenFeignUploadProductImage {


    @PostMapping(value = "/upload/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void call(@PathVariable Long productId, @RequestPart("files") MultipartFile[] files);
}