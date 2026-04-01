package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller;

import com.riu.challenge.hotel_availability_search.domain.exceptions.SearchNotFoundException;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.ErrorResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class RestExceptionHandlerTest {
    private final RestExceptionHandler handler = new RestExceptionHandler();

    @Test
    void handleSearchNotFoundException_returnsNotFoundAndErrorResponse() {
        String errorMsg = "No se encontró la búsqueda con id: 123";
        SearchNotFoundException ex = new SearchNotFoundException(errorMsg);
        ResponseEntity<ErrorResponseDTO> response = handler.handleSearchNotFoundException(ex);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(errorMsg, response.getBody().error());
    }
}
