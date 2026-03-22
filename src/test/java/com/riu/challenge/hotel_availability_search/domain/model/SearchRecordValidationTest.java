package com.riu.challenge.hotel_availability_search.domain.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SearchRecordValidationTest {
    @Test
    void throwsIfHotelIdNullOrBlank() {
        SearchId id = SearchId.generate();
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(1);
        List<Integer> ages = List.of(1);
        assertThrows(IllegalArgumentException.class, () -> new Search(id, null, checkIn, checkOut, ages));
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "", checkIn, checkOut, ages));
    }

    @Test
    void throwsIfCheckInOrCheckOutNull() {
        SearchId id = SearchId.generate();
        List<Integer> ages = List.of(1);
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", null, LocalDate.now(), ages));
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", LocalDate.now(), null, ages));
    }

    @Test
    void throwsIfCheckInNotBeforeCheckOut() {
        SearchId id = SearchId.generate();
        LocalDate d = LocalDate.now();
        List<Integer> ages = List.of(1);
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", d, d, ages));
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", d.plusDays(1), d, ages));
    }

    @Test
    void throwsIfAgesNullEmptyOrInvalid() {
        SearchId id = SearchId.generate();
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(1);
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", checkIn, checkOut, null));
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", checkIn, checkOut, List.of()));
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", checkIn, checkOut, List.of(0)));
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", checkIn, checkOut, List.of(-1)));
        assertThrows(IllegalArgumentException.class, () -> new Search(id, "H1", checkIn, checkOut, List.of((Integer) null)));
    }
}
