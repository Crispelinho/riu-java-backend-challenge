package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller;

import com.riu.challenge.hotel_availability_search.domain.exceptions.SearchNotFoundException;

import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.ErrorResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(SearchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseDTO> handleSearchNotFoundException(SearchNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponseDTO(ex.getMessage()));
    }
}
