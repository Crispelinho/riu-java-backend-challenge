package com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchEventMapper;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.event.CreateSearchEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SearchEventConsumerAdapter {

  private final SearchRepositoryPort searchRepositoryPort;

  public SearchEventConsumerAdapter(final SearchRepositoryPort searchRepositoryPort) {
    this.searchRepositoryPort = searchRepositoryPort;
  }

  @KafkaListener(topics = "hotel_availability_searches", groupId = "search-consumer-group")
  public void consume(final ConsumerRecord<String, CreateSearchEvent> kafkaRecord) {
    final CreateSearchEvent event = kafkaRecord.value();
    final Search search = SearchEventMapper.INSTANCE.toSearch(event);
    Thread.startVirtualThread(() -> searchRepositoryPort.save(search));
  }
}
