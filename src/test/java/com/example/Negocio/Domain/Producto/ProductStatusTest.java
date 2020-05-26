package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductStatusTest {

    @Test
    @DisplayName("Prueba del campo estado que debería pasar")
    void isShouldPass() {
        String state1 = "BORRADOR";
        String state2 = "PUBLICADO";

        assertAll(
                () -> assertEquals(ProductStatus.BORRADOR.toString(), state1),
                () -> assertEquals(ProductStatus.PUBLICADO.toString(), state2)
        );
    }

    @Test
    @DisplayName("Prueba del campo estado que NO debería pasar")
    void isShouldNotPass() {
        String state1 = "Estado1";
        String state2 = "";

        assertAll(
                () -> assertNotEquals(ProductStatus.BORRADOR.toString(), state1),
                () -> assertNotEquals(ProductStatus.PUBLICADO.toString(), state2)
        );
    }
}