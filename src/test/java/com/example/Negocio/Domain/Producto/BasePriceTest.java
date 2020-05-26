package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BasePriceTest {

    @Test
    @DisplayName("Prueba del campo precio base que debería pasar ")
    void isShouldPass() {

        BigDecimal precio1 = new BigDecimal("1518.1684684756146547");
        assertAll(
                () -> assertNotNull(BasePrice.of(precio1)),
                () -> assertTrue(precio1.doubleValue() > 0)
        );

    }
    @Test
    @DisplayName("Prueba del campo precio base que NO debería pasar ")
    void isShouldNotPass(){
        BigDecimal precio1 = new BigDecimal("-1518.1684684756146547");
        BigDecimal precio2 = null;

        assertAll(
                ()->assertThrows(NullPointerException.class,()->BasePrice.of(precio2)),
                ()->assertTrue(precio1.doubleValue()<0)
        );
    }
}