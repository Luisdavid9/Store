package com.example.Negocio.Serialization;

import com.example.Negocio.Domain.Producto.InventoryQuantity;
import com.example.Negocio.Domain.Producto.ProductId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongValueAdapterTest {
    static Gson gson;
    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(ProductId.class, new LongValueAdapter<>(ProductId::of))
                .create();
    }

    @Test
    void deserialize() {
        Long number = 88L;
        JsonElement element = new JsonPrimitive(number);
        ProductId number1 = ProductId.of(number);
        assertEquals(gson.fromJson(element, ProductId.class),number1);
    }

    @Test
    void serialize() {
        // organizar
        Long decimal = 88L;
        ProductId quantity = ProductId.of(decimal);
        //actuar
        Long actual = new Long(gson.toJson(quantity.getValue())); ;

        //comprueban
        Long expected = new Long(String.format("%s", quantity.getValue()));
        assertEquals(actual, expected);
    }
}