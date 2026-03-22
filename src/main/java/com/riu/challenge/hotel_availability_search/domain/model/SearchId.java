package com.riu.challenge.hotel_availability_search.domain.model;

import java.util.UUID;

public record SearchId(String value) {
    public SearchId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("searchId cannot be null or blank");
        }
    }

    public static SearchId generate() {
        return new SearchId(UUID.randomUUID().toString());
    }
}
