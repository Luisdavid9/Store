package com.example.Negocio.Domain.Producto;

import com.example.Negocio.Serialization.LongSerializable;
import com.example.Negocio.common.Preconditions;
import lombok.Value;



@Value(staticConstructor = "of")
public class ProductId implements LongSerializable {

 private final Long value;

    public ProductId(Long value)  {
        Preconditions.checkNotNull(value);
        Preconditions.smallestTypeLong(value);
        Preconditions.checkMaxCharacters(value,100);
        this.value = value;
    }

    @Override
    public Long valueOf() {
        return value;
    }
}
