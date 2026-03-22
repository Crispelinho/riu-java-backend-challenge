package com.riu.challenge.hotel_availability_search.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class SearchIdTest {
    @Test
    void constructorThrowsOnNullOrBlank() {
        assertThrows(IllegalArgumentException.class, () -> new SearchId(null));
        assertThrows(IllegalArgumentException.class, () -> new SearchId(" "));
    }

    @Test
    void constructorAcceptsValidValue() {
        String value = UUID.randomUUID().toString();
        SearchId id = new SearchId(value);
        assertEquals(value, id.getValue());
    }

    @Test
    void generateReturnsValidSearchId() {
        SearchId id = SearchId.generate();
        assertNotNull(id.getValue());
        assertFalse(id.getValue().isBlank());
    }
}
