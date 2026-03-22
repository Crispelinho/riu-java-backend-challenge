package com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.event;

import com.riu.challenge.hotel_availability_search.domain.model.SearchEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSearchEvent implements SearchEvent {

  private String searchId;

  private String hotelId;

  private LocalDate checkIn;

  private LocalDate checkOut;

  private List<Integer> ages;
}