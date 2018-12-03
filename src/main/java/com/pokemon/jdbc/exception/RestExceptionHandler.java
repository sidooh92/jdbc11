package com.pokemon.jdbc.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.pokemon.rest")
public class RestExceptionHandler  extends ResponseEntityExceptionHandler{


    @ExceptionHandler(value = { RestPokemonException.class})
    public ResponseEntity<Object> handleRestPokemon(Exception e, WebRequest webRequest) {
        String errorText = "Couldn't add new pokemon";
        return handleExceptionInternal(e, errorText, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);

    }
}
