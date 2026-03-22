package com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka;

import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.event.CreateSearchEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SearchEventProducerAdapter {

  private final KafkaTemplate<String, CreateSearchEvent> kafkaTemplate;

  private final String topic;

  public SearchEventProducerAdapter(final KafkaTemplate<String, CreateSearchEvent> kafkaTemplate,
      @Value("${app.kafka.topic:hotel_availability_searches}") final String topic) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
  }

  public void publishSearchEvent(final CreateSearchEvent event) {
    kafkaTemplate.send(topic, event.getSearchId(), event);
  }
}
