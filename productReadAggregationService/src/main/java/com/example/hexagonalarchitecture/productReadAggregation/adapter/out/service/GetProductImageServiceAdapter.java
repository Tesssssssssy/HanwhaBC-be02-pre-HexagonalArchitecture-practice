package com.example.hexagonalarchitecture.productReadAggregation.adapter.out.service;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.productReadAggregation.application.port.out.GetProductImagePort;
import com.example.hexagonalarchitecture.productReadAggregation.domain.ProductImage;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

import java.util.List;

@WebAdapter
@RequiredArgsConstructor
public class GetProductImageServiceAdapter implements GetProductImagePort {

    private final OpenFeignGetProductImages openFeignGetProductImages;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @Override
    public List<ProductImage> getProductImagePort(Long id) {
//        List<ProductImage> productImages = openFeignGetProductImages.call(id);

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("getProductImage");

        List<ProductImage> productImages = circuitBreaker.run(() ->
                openFeignGetProductImages.call(id)
                , throwable -> null
        );



        return productImages;
    }
}
