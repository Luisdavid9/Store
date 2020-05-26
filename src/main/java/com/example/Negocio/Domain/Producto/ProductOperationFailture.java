package com.example.Negocio.Domain.Producto;

import com.example.Negocio.exceptions.ProductDoesNotExist;
import com.example.Negocio.exceptions.ProductException;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationFailture implements ProductOperation {

    ProductDoesNotExist exception;
    @Override
    public ProductOperationRequest value() {
        return null;
    }

    @Override
    public ProductException failure() {
        return exception;
    }

    @Override
    public Boolean isValid() {
        return false;
    }
}
