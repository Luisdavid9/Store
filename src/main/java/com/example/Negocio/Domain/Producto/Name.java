package com.example.Negocio.Domain.Producto;

import com.example.Negocio.Serialization.StringSerializable;
import com.example.Negocio.common.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class Name implements StringSerializable {

    private final String value;

    public Name(String value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkNotEmpty(value);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}
