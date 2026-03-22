package com.riu.challenge.hotel_availability_search.application.commands;

import com.riu.challenge.hotel_availability_search.domain.model.SearchId;

public record GetSearchCommand(
    SearchId searchId
) {

}
