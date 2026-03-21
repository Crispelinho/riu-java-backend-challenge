package com.riu.challenge.hotel_availability_search.application.commands;

import java.time.LocalDate;
import java.util.List;

public record CreateSearchCommand(
    String hotelId,
    LocalDate checkIn,
    LocalDate checkOut,
    List<Integer> ages
) {
}
