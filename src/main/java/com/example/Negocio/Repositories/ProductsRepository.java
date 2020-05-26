package com.example.Negocio.Repositories;

import com.example.Negocio.Domain.Producto.Product;
import com.example.Negocio.Domain.Producto.ProductOperation;
import com.example.Negocio.Domain.Producto.ProductOperationRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository {

    ProductOperation insertOne(ProductOperationRequest operationRequest);

    ProductOperation findById(Long id);

    List<ProductOperationRequest> findAll();

    ProductOperation updateOne(Long id, ProductOperationRequest operationRequest);

    ProductOperation deleteOne(Long id);

}
