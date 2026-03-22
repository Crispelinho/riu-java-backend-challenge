package com.riu.challenge.hotel_availability_search.domain.ports;

import java.time.LocalDate;
import java.util.List;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;

public interface SearchRepositoryPort {

  Search save(Search search);

  Search findById(SearchId searchId);

  long countEquivalentSearches(final String hotelId,
                              final LocalDate checkIn,
                              final LocalDate checkOut,
                              final List<Integer> ages);
}
