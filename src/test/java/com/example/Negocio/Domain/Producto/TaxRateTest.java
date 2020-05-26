package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxRateTest {

    @Test
    @DisplayName("Prueba del campo tax  base que debería pasar ")
    void isShouldPass() {

        BigDecimal TaxDecimal = new BigDecimal("0.1684684756146547");
        assertAll(
                () -> assertNotNull(TaxRate.of(TaxDecimal)),
                () -> assertTrue(TaxDecimal.doubleValue() > 0),
                () -> assertTrue(TaxDecimal.doubleValue() < 1)
        );

    }

    @Test
    @DisplayName("Prueba del campo tax base que NO debería pasar ")
    void isShouldNotPass() {
        BigDecimal TaxDecimal1 = new BigDecimal("-165756.1684684756146547");
        BigDecimal TaxDecimal2 = null;
        BigDecimal TaxDecimal3 = new BigDecimal("2.1684684756146547");
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> TaxRate.of(TaxDecimal2)),
                () -> assertTrue(TaxDecimal1.doubleValue() < 0),
                () -> assertTrue(TaxDecimal3.doubleValue() > 1)
        );
    }

}