package com.riu.challenge.hotel_availability_search.domain.exceptions;

public class SearchNotFoundException extends RuntimeException {
    public SearchNotFoundException(final String message) {
        super(message);
    }
}
