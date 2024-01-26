package com.example.demo.controller;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Log4j2
@ControllerAdvice(basePackages = "com.example.demo.controller")
public class HandlerError {

    @ExceptionHandler(FeignException.class)
    ResponseEntity<String> handleException(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>("Ah ocurrido un error", INTERNAL_SERVER_ERROR);
    }

}
