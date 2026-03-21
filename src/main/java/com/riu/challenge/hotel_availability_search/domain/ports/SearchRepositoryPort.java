package com.riu.challenge.hotel_availability_search.domain.ports;

import com.riu.challenge.hotel_availability_search.domain.model.Search;

public interface SearchRepositoryPort {

  Search save(Search search);

  long countByHotelIdAndCheckInAndCheckOutAndAges(String searchId);
}
