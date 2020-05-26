package com.example.Negocio.Configuration;

import com.example.Negocio.Domain.Producto.*;
import com.example.Negocio.Serialization.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .registerTypeAdapter(ProductId.class, new LongValueAdapter<>(ProductId::of))
                .registerTypeAdapter(Name.class, new StringValueAdapter<>(Name::of))
                .registerTypeAdapter(Description.class, new StringValueAdapter<>(Description::of))
                .registerTypeAdapter(BasePrice.class, new BigDecimalValueAdapter<>(BasePrice::of))
                .registerTypeAdapter(TaxRate.class, new BigDecimalValueAdapter<>(TaxRate::of))
                .registerTypeAdapter(InventoryQuantity.class, new IntegerValueAdapter<>(InventoryQuantity::of))
                .create();
    }
}
