package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SearchRequestDTO(
    @NotBlank String hotelId,
    @NotBlank String checkIn,
    @NotBlank String checkOut,
    @NotNull Integer[] ages) {

}
