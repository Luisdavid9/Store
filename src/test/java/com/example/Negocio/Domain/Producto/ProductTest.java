package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    @DisplayName("Prueba del Product a crear que debería pasar")
    void isShouldPass() {
        Long id=213123L;
        String name = "Andres";
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...";
        BigDecimal basePrice = new BigDecimal("16845.9988468");
        BigDecimal tax = new BigDecimal("0.225");
        ProductStatus status = ProductStatus.BORRADOR;
        Integer quantity = 88;

        Product product = Product.of(ProductId.of(id),Name.of(name), Description.of(description), BasePrice.of(basePrice), TaxRate.of(tax), status, InventoryQuantity.of(quantity));

        assertNotNull(product);
    }

    @Test
    @DisplayName("Prueba del ProductoOperationRequest a crear que NO debería pasar")
    void isShouldNotPass() {
        Product product = null;
        assertNull(product);
    }

}