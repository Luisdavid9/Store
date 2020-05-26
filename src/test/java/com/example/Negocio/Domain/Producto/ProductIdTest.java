package com.example.Negocio.Domain.Producto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductIdTest {



    @Test
    void isShouldNotPass(){
        Long id1 =null;
        Long id2 = 0L;

        assertAll(
                ()-> assertThrows(NullPointerException.class,()->ProductId.of(id1)),
                ()-> assertThrows(NumberFormatException.class,()->ProductId.of(id2))
        );

    }


    @Test
    void isShouldPass() {

        Long id1 = 8L;
        Long id2 = 80L;
        Long id3 = 800L;

        assertAll(
                () -> assertNotNull(ProductId.of(id1)),
                () -> assertNotNull(ProductId.of(id2)),
                () -> assertNotNull(ProductId.of(id3))
        );

    }

}