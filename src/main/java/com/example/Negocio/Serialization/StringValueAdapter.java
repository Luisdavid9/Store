package com.example.Negocio.Serialization;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.function.Function;

public class StringValueAdapter <T extends StringSerializable> implements GsonAdapter<T>{

    private final Function<String, T> factory;

    public StringValueAdapter(Function<String, T> factory) {
        this.factory = factory;
    }

    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String value = jsonElement.getAsString();
        return factory.apply(value);
    }

    @Override
    public JsonElement serialize(T src, Type type, JsonSerializationContext jsonSerializationContext) {
        String value = src.valueOf();
        return new JsonPrimitive(value);
    }
}
