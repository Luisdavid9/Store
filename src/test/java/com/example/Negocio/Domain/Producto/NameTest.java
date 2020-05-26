package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {


    @Test
    @DisplayName("Prueba del campo nombre que debería pasar")
    void isShouldPass(){
        String name1 = "Andres";
        int longitud = name1.length();
        assertAll(
                ()->  assertNotNull(Name.of(name1)),
                ()->assertNotEquals(Description.of(name1),""),
                ()->assertTrue(longitud<100)
        );
    }

    @Test
    @DisplayName("Prueba del campo nombre que NO debería pasar")
    void isShoulNotPass(){
        String name1 = null;
        String name2 = "";

        assertAll(
                ()->assertThrows(NullPointerException.class,()->Name.of(name1)),
                ()->assertThrows(IllegalArgumentException.class,()->Name.of(name2))
        );
    }

}