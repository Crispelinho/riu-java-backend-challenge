package com.riu.challenge.hotel_availability_search.domain.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    @Test
    void canCreateSearchWithAllFields() {
        SearchId id = SearchId.generate();
        String hotelId = "H1";
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(2);
        List<Integer> ages = List.of(30, 25);
        Search search = new Search(id, hotelId, checkIn, checkOut, ages);
        assertEquals(id, search.getSearchId());
        assertEquals(hotelId, search.getHotelId());
        assertEquals(checkIn, search.getCheckIn());
        assertEquals(checkOut, search.getCheckOut());
        assertEquals(ages, search.getAges());
    }

    @Test
    void noArgsConstructorWorks() {
        Search search = new Search();
        assertNull(search.getSearchId());
        assertNull(search.getHotelId());
        assertNull(search.getCheckIn());
        assertNull(search.getCheckOut());
        assertNull(search.getAges());
    }
}
