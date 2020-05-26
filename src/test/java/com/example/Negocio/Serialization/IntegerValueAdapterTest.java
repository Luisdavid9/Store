package com.example.Negocio.Serialization;

import com.example.Negocio.Domain.Producto.BasePrice;
import com.example.Negocio.Domain.Producto.InventoryQuantity;
import com.example.Negocio.Domain.Producto.Name;
import com.example.Negocio.Domain.Producto.TaxRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IntegerValueAdapterTest {
    static Gson gson;
    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(InventoryQuantity.class, new IntegerValueAdapter<>(InventoryQuantity::of))
                .create();
    }

    @Test
    void deserialize() {
        Integer number = 88;
        JsonElement element = new JsonPrimitive(number);
        InventoryQuantity number1 = InventoryQuantity.of(number);
        assertEquals(gson.fromJson(element, InventoryQuantity.class),number1);
    }

    @Test
    void serialize() {
        // organizar
        Integer decimal = 88;
        InventoryQuantity quantity = InventoryQuantity.of(decimal);
        //actuar
        Integer actual = new Integer(gson.toJson(quantity.getValue())); ;

        //comprueban
        Integer expected = new Integer(String.format("%s", quantity.getValue()));
        assertEquals(actual, expected);
    }


}