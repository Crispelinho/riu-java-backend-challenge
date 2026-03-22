package com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository;

import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.entities.SearchEntity;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SearchRepositoryTest {
    @Test
    void canInstantiateEntity() {
        SearchEntity entity = new SearchEntity();
        entity.setSearchId("id");
        entity.setHotelId("hotel");
        entity.setCheckInDate(LocalDate.now());
        entity.setCheckOutDate(LocalDate.now().plusDays(1));
        entity.setAges(List.of(1,2));
        assertEquals("id", entity.getSearchId());
        assertEquals("hotel", entity.getHotelId());
        assertNotNull(entity.getCheckInDate());
        assertNotNull(entity.getCheckOutDate());
        assertEquals(List.of(1,2), entity.getAges());
    }
}
