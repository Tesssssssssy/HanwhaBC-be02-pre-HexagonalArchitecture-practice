package com.example.hexagonalarchitecture.productReadAggregation.adapter.out.service;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.productReadAggregation.application.port.out.GetProductPort;
import com.example.hexagonalarchitecture.productReadAggregation.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

@WebAdapter
@RequiredArgsConstructor
public class GetProductServiceAdapter implements GetProductPort {
    private final OpenFeignGetProduct openFeignGetProduct;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @Override
    public Product getProductPort(Long id) {
//        Product product = openFeignGetProduct.call(id);

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("getProduct");

        Product product = circuitBreaker.run(() ->
                openFeignGetProduct.call(id)
                , throwable -> null
        );


        return product;
    }
}
