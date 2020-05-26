package com.example.Negocio.Domain.Producto;

import com.example.Negocio.Serialization.StringSerializable;
import com.example.Negocio.common.Preconditions;
import lombok.Value;


@Value(staticConstructor = "of")
public class Description implements StringSerializable {

    private final String value;

    public Description(String value) {
        Preconditions.checkNotNull(value);
        Preconditions.checkNotEmpty(value);
        Preconditions.checkMaxCharacters(value,280);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}
