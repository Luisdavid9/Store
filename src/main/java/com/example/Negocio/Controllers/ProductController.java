package com.example.Negocio.Controllers;


import com.example.Negocio.Domain.Producto.Product;
import com.example.Negocio.Domain.Producto.ProductOperation;
import com.example.Negocio.Domain.Producto.ProductOperationRequest;
import com.example.Negocio.Services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/times")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService service;

    @CrossOrigin
    @PostMapping
    public ProductOperationRequest insertOne(@RequestBody ProductOperationRequest operationRequest) {
        service.insertOne(operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
        return operationRequest;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ProductOperation findById(@PathVariable Long id) {
        ProductOperation optionalUser = service.findById(id);
        return optionalUser;
    }
    @CrossOrigin
    @GetMapping("list")
    public List<ProductOperationRequest> findAll() {
        return service.findAll();
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ProductOperation updateOne(@PathVariable Long id, @RequestBody ProductOperationRequest operationRequest) {
        service.updateOne(id, operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
        return service.updateOne(id, operationRequest.getName(), operationRequest.getDescription(), operationRequest.getBasePrice(), operationRequest.getTaxRate(),
                operationRequest.getProductStatus(), operationRequest.getInventoryQuantity());
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ProductOperation deleteOne(@PathVariable Long id) {
        return service.deleteOne(id);
    }
}
