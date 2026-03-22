package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchIdResponseDTOTest {
    @Test
    void canCreateAndAccess() {
        SearchIdResponseDTO dto = new SearchIdResponseDTO("id123");
        assertEquals("id123", dto.searchId());
    }
}
