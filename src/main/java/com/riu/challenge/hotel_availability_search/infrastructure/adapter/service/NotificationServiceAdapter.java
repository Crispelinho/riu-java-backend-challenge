package com.riu.challenge.hotel_availability_search.infrastructure.adapter.service;

import com.riu.challenge.hotel_availability_search.application.ports.NotificationServicePort;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.SearchEventMapper;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.SearchEventProducerAdapter;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.event.CreateSearchEvent;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceAdapter implements NotificationServicePort {
    private final SearchEventProducerAdapter searchEventProducerAdapter;

    @Override
    public void publishSearchCreatedEvent(Search search) {
        CreateSearchEvent event = SearchEventMapper.INSTANCE.toCreateSearchEvent(search);
        searchEventProducerAdapter.publishSearchEvent(event);
    }
}
