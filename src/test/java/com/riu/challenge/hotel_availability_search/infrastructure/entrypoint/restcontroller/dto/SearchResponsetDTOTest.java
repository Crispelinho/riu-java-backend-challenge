package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchResponsetDTOTest {
    @Test
    void canCreateAndAccess() {
        int[] ages = {1,2};
        SearchResponsetDTO dto = new SearchResponsetDTO("H1", "01/01/2026", "02/01/2026", ages);
        assertEquals("H1", dto.hotelId());
        assertEquals("01/01/2026", dto.checkIn());
        assertEquals("02/01/2026", dto.checkOut());
        assertArrayEquals(ages, dto.ages());
    }
}
