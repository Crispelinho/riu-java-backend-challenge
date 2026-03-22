package com.riu.challenge.hotel_availability_search.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record Search(
  SearchId searchId,
  String hotelId,
  LocalDate checkIn,
  LocalDate checkOut,
  List<Integer> ages
) {
  public Search {
    Objects.requireNonNull(searchId, "searchId no puede ser null");
    if (hotelId == null || hotelId.isBlank()) {
      throw new IllegalArgumentException("hotelId no puede ser null o vacío");
    }
    if (checkIn == null || checkOut == null) {
      throw new IllegalArgumentException("checkIn y checkOut no pueden ser null");
    }
    if (!checkIn.isBefore(checkOut)) {
      throw new IllegalArgumentException("checkIn debe ser anterior a checkOut");
    }
    if (ages == null) {
      throw new IllegalArgumentException("Ages no puede ser null");
    }
    if (ages.isEmpty()) {
      throw new IllegalArgumentException("Ages no puede estar vacío");
    }
    if (ages.stream().anyMatch(a -> a == null)) {
      throw new IllegalArgumentException("Ages no puede contener nulls");
    }
    if (ages.stream().anyMatch(a -> a <= 0)) {
      throw new IllegalArgumentException("Ages debe ser > 0");
    }

    ages = List.copyOf(ages);
  }
}
