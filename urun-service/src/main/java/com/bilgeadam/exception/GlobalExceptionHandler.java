package com.bilgeadam.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

import static com.bilgeadam.exception.ErrorType.*;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.badRequest().body("Beklenmeyen bir hata oldu..: "+ex.getMessage());
    }

    @ExceptionHandler(UrunServiceException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMonolitichException(UrunServiceException ex){
        ErrorType errorType = ex.getErrorType();
        HttpStatus httpStatus = errorType.getHttpStatus();
        return new ResponseEntity(createError(errorType,ex),httpStatus);
    }

















    /**
     * Error Messagelarınızı özel bir method içinde create edin. çünkü oluşan hataların
     * log lanması yada farklı işlemelere tabi tutulması için ayrıca bir methosd kullanmak
     * daha doğru olacaktır.
     */
    private ErrorMessage createError(ErrorType errorType, Exception exception){
        System.out.println("Hata oluştu..: "+exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }
}
