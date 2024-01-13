package com.example.hexagonalarchitecture.productReadAggregation.adapter.in.web;

import com.example.hexagonalarchitecture.common.WebAdapter;
import com.example.hexagonalarchitecture.productReadAggregation.application.port.in.GetProductAggregationUseCase;
import com.example.hexagonalarchitecture.productReadAggregation.domain.ProductAggregation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetProductAggregationController {
    private final GetProductAggregationUseCase getProductAggregationUseCase;
    @RequestMapping(method = RequestMethod.GET, value = "/product/read/{id}")
    ProductAggregation getProductAggregation(@PathVariable Long id) {

        return getProductAggregationUseCase.getProductAggregation(id);
    }
}
