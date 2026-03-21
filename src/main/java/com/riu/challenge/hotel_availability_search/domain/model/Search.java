package com.riu.challenge.hotel_availability_search.domain.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search {
  private SearchId searchId;
  private String hotelId;
  private LocalDate checkIn;
  private LocalDate checkOut;
  private List<Integer> ages;
}
