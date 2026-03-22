package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchCountResponseDTOTest {
    @Test
    void canCreateAndAccess() {
        SearchResponsetDTO dto = new SearchResponsetDTO("H1", "01/01/2026", "02/01/2026", new int[]{1,2});
        SearchCountResponseDTO countDto = new SearchCountResponseDTO("id", dto, 5L);
        assertEquals("id", countDto.searchId());
        assertEquals(dto, countDto.search());
        assertEquals(5L, countDto.count());
    }
}
