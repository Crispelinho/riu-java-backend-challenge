package com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SearchEventConsumerAdapter {
    private final SearchRepositoryPort searchRepositoryPort;

    public SearchEventConsumerAdapter(SearchRepositoryPort searchRepositoryPort) {
        this.searchRepositoryPort = searchRepositoryPort;
    }

        @KafkaListener(topics = "hotel_availability_searches", groupId = "search-consumer-group")
        public void consume(ConsumerRecord<String, CreateSearchEvent> kafkaRecord) {
            CreateSearchEvent event = kafkaRecord.value();
            Search search = SearchEventMapper.INSTANCE.toSearch(event);
            Thread.startVirtualThread(() -> searchRepositoryPort.save(search));
    }
}
