package com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.entities.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<SearchEntity, Long> {
  @Query(value = QueryConstants.COUNT_EQUIVALENT_SEARCHES, nativeQuery = true)
  long countEquivalentSearchesDb(@Param("hotelId") String hotelId, @Param("checkIn") java.time.LocalDate checkIn, @Param("checkOut") java.time.LocalDate checkOut, @Param("ages") java.util.List<Integer> ages);

  List<SearchEntity> findByHotelIdAndCheckInDateAndCheckOutDate(String hotelId, LocalDate checkIn, LocalDate checkOut);
  SearchEntity findBySearchId(String searchId);
}
