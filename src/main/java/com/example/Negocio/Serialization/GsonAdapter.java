package com.example.Negocio.Serialization;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

public interface GsonAdapter<T>  extends JsonDeserializer<T>, JsonSerializer<T> {

}
