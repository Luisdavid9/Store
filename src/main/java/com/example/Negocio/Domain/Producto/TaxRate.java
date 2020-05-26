package com.example.Negocio.Domain.Producto;

import com.example.Negocio.Serialization.BigDecimalSerializable;
import com.example.Negocio.common.Preconditions;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")

public class TaxRate implements BigDecimalSerializable {
    private final BigDecimal value;

    public TaxRate(BigDecimal value) {
        Preconditions.checkNotNull(value);
        Preconditions.highestTypeBigDecimal(value);
        Preconditions.smallestTypeBigDecimal(value);
        this.value = value;
    }

    @Override
    public BigDecimal valueOf() {
        return value;
    }
}
