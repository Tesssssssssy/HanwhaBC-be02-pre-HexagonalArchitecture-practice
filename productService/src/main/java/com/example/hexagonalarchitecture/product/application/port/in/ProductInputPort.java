package com.example.hexagonalarchitecture.product.application.port.in;


import com.example.hexagonalarchitecture.product.domain.Product;

public interface ProductInputPort {
    Product registerProduct(RegisterProductCommand registerProductCommand);

}
