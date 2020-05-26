package com.example.Negocio.Domain.Producto;

import com.example.Negocio.Serialization.IntegerSerializable;
import com.example.Negocio.common.Preconditions;
import lombok.Value;

@Value(staticConstructor = "of")
public class InventoryQuantity implements IntegerSerializable {
    private final Integer value;

    public InventoryQuantity(Integer value) {
        Preconditions.checkNotNull(value);
        Preconditions.smallestTypeInteger(value);
        this.value = value;
    }


    @Override
    public Integer valueOf() {
        return value;
    }
}
