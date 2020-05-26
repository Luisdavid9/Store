package com.example.Negocio.Configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebAplicationConfiguration implements WebMvcConfigurer {

    private final Gson gson;

    public WebAplicationConfiguration(Gson gson){
        this.gson = gson;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter(gson);
        converters.add(gsonHttpMessageConverter);
    }
}
