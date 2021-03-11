package com.pplflw.test.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HTTP400Exception.class)
    public final ResponseEntity<Object> handleHTTP400Exception(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse("01", new Date(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(HTTP404Exception.class)
    public final ResponseEntity<Object> handleHTTP404Exception(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("01", new Date(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }



    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("01", new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);

    }



}
