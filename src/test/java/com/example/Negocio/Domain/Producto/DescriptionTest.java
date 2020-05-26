package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.crypto.Des;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionTest {

    @Test
    @DisplayName("Prueba del campo descripcion que debería pasar")
    void isShouldPass() {
        String descripcion1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...";
        int longitud = descripcion1.length();
        assertAll(
                () -> assertNotNull(Description.of(descripcion1)),
                () -> assertNotEquals(Description.of(descripcion1), ""),
                () -> assertTrue(longitud < 280)
        );
    }

    @Test
    @DisplayName("Prueba del campo descripcion que NO debería pasar")
    void isShoulNotPass() {
        String description1 = null;
        String description2 = "";
        String description3 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed...";

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> Description.of(description1)),
                () -> assertThrows(IllegalArgumentException.class, () -> Description.of(description2)),
                () -> assertThrows(IllegalArgumentException.class, () -> Description.of(description3))
        );
    }


}