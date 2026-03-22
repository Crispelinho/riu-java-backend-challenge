package com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository;

import com.riu.challenge.hotel_availability_search.domain.exceptions.SearchNotFoundException;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.entities.SearchEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SearchRepositoryAdapterTest {
    private SearchRepository searchRepository;
    private SearchRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        searchRepository = mock(SearchRepository.class);
        adapter = new SearchRepositoryAdapter(searchRepository);
    }

    @Test
    void saveDelegatesToRepository() {
        Search search = new Search(
            SearchId.generate(),
            "hotelId",
            LocalDate.now(),
            LocalDate.now().plusDays(1),
            List.of(25, 30)
        );
        SearchEntity entity = new SearchEntity();
        entity.setSearchId(search.getSearchId().getValue());
        entity.setHotelId(search.getHotelId());
        entity.setCheckInDate(search.getCheckIn());
        entity.setCheckOutDate(search.getCheckOut());
        entity.setAges(search.getAges());
        when(searchRepository.save(any())).thenReturn(entity);
        when(searchRepository.findBySearchId(any())).thenReturn(entity);
        Search result = adapter.save(search);
        assertNotNull(result);
        assertEquals(search.getSearchId().getValue(), result.getSearchId().getValue());
    }

    @Test
    void findByIdThrowsIfNotFound() {
        when(searchRepository.findBySearchId(any())).thenReturn(null);
        assertThrows(SearchNotFoundException.class, () -> adapter.findById(new SearchId("id")));
    }

    @Test
    void countEquivalentSearchesFiltersAges() {
        SearchEntity entity = new SearchEntity();
        entity.setAges(List.of(1,2));
        when(searchRepository.findByHotelIdAndCheckInDateAndCheckOutDate(any(), any(), any())).thenReturn(List.of(entity));
        long count = adapter.countEquivalentSearches("H1", LocalDate.now(), LocalDate.now(), List.of(1,2));
        assertEquals(1, count);
    }
}
