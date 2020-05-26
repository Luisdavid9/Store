package com.example.Negocio.Domain.Producto;

import com.example.Negocio.exceptions.ProductException;

public interface ProductOperation {

    ProductOperationRequest value();

    ProductException failure();

    Boolean isValid();
}
