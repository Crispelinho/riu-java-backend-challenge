package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto;

import com.riu.challenge.hotel_availability_search.domain.model.SearchId;

public record SearchCountResponseDTO (
    String searchId,
    SearchRequestDTO search,
    String count){
}
