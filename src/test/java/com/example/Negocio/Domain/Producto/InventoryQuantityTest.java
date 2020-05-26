package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryQuantityTest {

    @Test
    @DisplayName("Prueba del campo cantidad que debería pasar ")
    void isShouldPass() {
        Integer cantidad = 88;

        assertAll(
                () -> assertNotNull(InventoryQuantity.of(cantidad)),
                () -> assertTrue(cantidad > 0)
        );
    }

    @Test
    @DisplayName("Prueba del campo cantidad que NO debería pasar ")
    void isShloudNotPass(){
        Integer cantidad1 = null;
        Integer cantidad2 = -1;

        assertAll(
                ()->assertNull(cantidad1),
                ()->assertTrue(cantidad2 <0)
        );
    }

}