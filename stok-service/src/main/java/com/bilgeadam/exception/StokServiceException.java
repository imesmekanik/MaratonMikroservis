package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class StokServiceException extends RuntimeException{
    private final ErrorType errorType;

    public StokServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public StokServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
