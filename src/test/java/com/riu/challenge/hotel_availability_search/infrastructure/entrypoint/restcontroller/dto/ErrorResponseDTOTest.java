package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseDTOTest {
    @Test
    void errorResponseDTOStoresError() {
        String error = "some error";
        ErrorResponseDTO dto = new ErrorResponseDTO(error);
        assertEquals(error, dto.error());
    }
}
