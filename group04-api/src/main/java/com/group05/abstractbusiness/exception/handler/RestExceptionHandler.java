package com.group05.abstractbusiness.exception.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.group05.abstractbusiness.exception.BadRequestException;
import com.group05.abstractbusiness.exception.ValidationException;
import com.group05.abstractbusiness.exception.details.BadRequestDetails;
import com.group05.abstractbusiness.exception.details.ExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestDetails> handler(BadRequestException exception){
        return new ResponseEntity<>(
            BadRequestDetails.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .title("Bad request Excption")
            .details(exception.getMessage())
            .developerMessage(exception.getClass().getName())
            .time(LocalDateTime.now())
            .build(), HttpStatus.BAD_REQUEST
        );    
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException> handler(MethodArgumentNotValidException exception){
        List<FieldError>fieldErro = exception.getBindingResult().getFieldErrors();
        String fields = fieldErro.stream().map(FieldError::getField).collect((Collectors.joining(",")));
        String fieldsMessage = fieldErro.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        
        return new ResponseEntity<>(
            ValidationException.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .title("Bad request Excption")
            .details(exception.getMessage())
            .developerMessage(exception.getClass().getName())
            .time(LocalDateTime.now())
            .fields(fields)
            .fieldsMessage(fieldsMessage)
            .build(), HttpStatus.BAD_REQUEST
        );   
    }
}
