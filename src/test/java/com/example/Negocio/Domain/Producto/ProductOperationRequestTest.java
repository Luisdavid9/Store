package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductOperationRequestTest {


    @Test
    @DisplayName("Prueba del ProductoOperationRequest a crear que debería pasar")
    void isShouldPass() {

        String name = "Andres";
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...";
        BigDecimal basePrice = new BigDecimal("16845.9988468");
        BigDecimal tax = new BigDecimal("0.225");
        ProductStatus status = ProductStatus.BORRADOR;
        Integer quantity = 88;

        ProductOperationRequest productOperationRequest = ProductOperationRequest.of(Name.of(name), Description.of(description), BasePrice.of(basePrice), TaxRate.of(tax), status, InventoryQuantity.of(quantity));

        assertNotNull(productOperationRequest);
    }

    @Test
    @DisplayName("Prueba del ProductoOperationRequest a crear que NO debería pasar")
    void isShouldNotPass() {
        ProductOperationRequest productOperationRequest = null;
        assertNull(productOperationRequest);

    }
}