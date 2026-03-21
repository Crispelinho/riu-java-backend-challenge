package com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository;

import java.time.LocalDate;
import java.util.List;

import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.entities.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<SearchEntity, Long> {

  long countByHotelIdAndCheckInAndCheckOutAndAges(String hotelId, LocalDate checkIn, LocalDate checkOut, List<Integer> ages);
  SearchEntity findBySearchId(String searchId);
}
