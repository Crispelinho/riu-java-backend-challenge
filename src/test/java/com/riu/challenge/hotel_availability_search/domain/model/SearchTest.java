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
        assertEquals(id, search.searchId());
        assertEquals(hotelId, search.hotelId());
        assertEquals(checkIn, search.checkIn());
        assertEquals(checkOut, search.checkOut());
        assertEquals(ages, search.ages());
    }
}
