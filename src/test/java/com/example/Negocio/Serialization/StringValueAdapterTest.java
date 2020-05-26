package com.example.Negocio.Serialization;

import com.example.Negocio.Domain.Producto.Name;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValueAdapterTest {
    static Gson gson;
    @BeforeAll
    static void setUp() {
        gson = new GsonBuilder()
                .registerTypeAdapter(Name.class, new StringValueAdapter<>(Name::of))
                .create();
    }


    @Test
    void deserialize() {
        String name = "Camilo";
        JsonElement element = new JsonPrimitive(name);
        Name name1 = Name.of(name);
        assertEquals(gson.fromJson(element, Name.class),name1);
    }

    @Test
    void serialize() {
        // organizar
        String usernameString = "Andres";
        Name name = Name.of(usernameString);

        //actuar
        String actual = gson.toJson(name);

        //comprueban
        String expected = String.format("\"%s\"", name.getValue());
        assertEquals(actual, expected);
    }

}