package com.riu.challenge.hotel_availability_search.application.ports;

import com.riu.challenge.hotel_availability_search.domain.model.Search;

public interface NotificationServicePort {
    void publishSearchCreatedEvent(Search search);
}