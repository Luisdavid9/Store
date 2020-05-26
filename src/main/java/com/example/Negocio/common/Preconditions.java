package com.example.Negocio.common;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.naming.LimitExceededException;
import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Objects;

public class Preconditions {

    public static void checkNotNull(Object reference){
        if(Objects.isNull(reference)){
            throw new NullPointerException();
        }
    }

    public static void checkNotEmpty(Object reference){
        if(reference.toString().isEmpty()){
            throw  new IllegalArgumentException();
        }
    }

    public  static void checkMaxCharacters(Object reference, int quantity) {
        if(reference.toString().length() >quantity){
            throw  new IllegalArgumentException();
        }
    }

    public static void smallestTypeLong(Long reference){
        if(reference < 1){
            throw  new NumberFormatException();
        }
    }

    public static void smallestTypeBigDecimal(BigDecimal reference){
        if(reference.doubleValue()  < 0){
            throw  new NumberFormatException();
        }
    }
    public static void highestTypeBigDecimal(BigDecimal reference){

        if(reference.doubleValue() > 1.0){
            throw  new NumberFormatException();
        }
    }

    public static void smallestTypeInteger(Integer reference){
        if(reference < 0){
            throw  new NumberFormatException();
        }
    }

}
