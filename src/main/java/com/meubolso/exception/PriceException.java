package com.meubolso.exception;

public class PriceException extends RuntimeException{

    public PriceException(String error){
        super(error);
    }
}
