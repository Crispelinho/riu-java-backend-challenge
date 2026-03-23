package com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka;

import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.event.CreateSearchEvent;

import com.riu.challenge.hotel_availability_search.application.ports.LogServicePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SearchEventProducerAdapter {
  private final KafkaTemplate<String, CreateSearchEvent> kafkaTemplate;
  private final String topic;
  private final LogServicePort logService;

  public SearchEventProducerAdapter(
      final KafkaTemplate<String, CreateSearchEvent> kafkaTemplate,
      @Value("${app.kafka.topic:hotel_availability_searches}") final String topic,
      final LogServicePort logService) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
    this.logService = logService;
  }

  public void publishSearchEvent(final CreateSearchEvent event) {
    logService.logInfo("SearchEventProducerAdapter", "Producing event to topic '" + topic + "': " + event);
    kafkaTemplate.send(topic, event.getSearchId(), event);
  }
}
