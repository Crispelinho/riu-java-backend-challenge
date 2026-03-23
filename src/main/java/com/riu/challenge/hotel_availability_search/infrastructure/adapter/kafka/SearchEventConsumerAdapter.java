package com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchEventMapper;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.event.CreateSearchEvent;

import lombok.AllArgsConstructor;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import com.riu.challenge.hotel_availability_search.application.ports.LogServicePort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SearchEventConsumerAdapter {
  private final SearchRepositoryPort searchRepositoryPort;
  private final LogServicePort logService;



  @KafkaListener(topics = "hotel_availability_searches", groupId = "search-consumer-group")
  public void consume(final ConsumerRecord<String, CreateSearchEvent> kafkaRecord) {
    final CreateSearchEvent event = kafkaRecord.value();
    logService.logInfo("Consumed event from topic '" + kafkaRecord.topic() + "': " + event);
    final Search search = SearchEventMapper.INSTANCE.toSearch(event);
    Thread.startVirtualThread(() -> searchRepositoryPort.save(search));
  }
}
