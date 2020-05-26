package com.example.Negocio.Serialization;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.function.Function;

public class BigDecimalValueAdapter<T extends BigDecimalSerializable> implements GsonAdapter<T>  {

    private final Function<BigDecimal, T> factory;


    public BigDecimalValueAdapter(Function<BigDecimal, T> factory) {
        this.factory = factory;
    }


    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        BigDecimal value = jsonElement.getAsBigDecimal();
        return factory.apply(value);
    }

    @Override
    public JsonElement serialize(T src, Type type, JsonSerializationContext jsonSerializationContext) {
        BigDecimal value = src.valueOf();
        return new JsonPrimitive(value);
    }
}
