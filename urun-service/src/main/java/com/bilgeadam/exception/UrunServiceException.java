package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class UrunServiceException extends RuntimeException{
    private final ErrorType errorType;

    public UrunServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public UrunServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
