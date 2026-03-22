package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto;

public record SearchCountResponseDTO (
    String searchId,
    SearchResponsetDTO search,
    long count){
}
