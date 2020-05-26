package com.example.Negocio.Serialization;

import com.example.Negocio.Domain.Producto.BasePrice;
import com.example.Negocio.Domain.Producto.Name;
import com.example.Negocio.Domain.Producto.TaxRate;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalValueAdapterTest {
    static Gson gson;
    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(BasePrice.class, new BigDecimalValueAdapter<>(BasePrice::of))
                .create();
    }

    @Test
    void deserialize() {
        BigDecimal number = new BigDecimal("64846.648454");
        JsonElement element = new JsonPrimitive(number);
        BasePrice number1 = BasePrice.of(number);
        assertEquals(gson.fromJson(element, BasePrice.class),number1);
    }

    @Test
    void serialize() {
        // organizar
        BigDecimal decimal = new BigDecimal("0.22684");
        TaxRate taxRate =TaxRate.of(decimal);


        //actuar
        BigDecimal actual = new BigDecimal(gson.toJson(taxRate.getValue())); ;

        //comprueban
        BigDecimal expected = new BigDecimal (String.format("%s", taxRate.getValue()));
        assertEquals(actual, expected);
    }
}