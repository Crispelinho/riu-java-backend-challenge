package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.application.ports.NotificationServicePort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CreateSearchUseCaseTest {

  @Test
  void executePublishesEventAndReturnsSearchId() {
    final NotificationServicePort notificationServicePort = mock(NotificationServicePort.class);
    final CreateSearchCommand cmd = new CreateSearchCommand("H1", LocalDate.now(), LocalDate.now().plusDays(1), List.of(1, 2));
    final CreateSearchUseCase useCase = new CreateSearchUseCase(notificationServicePort);
    final var result = useCase.execute(cmd);
    verify(notificationServicePort).publishSearchCreatedEvent(any(Search.class));
    assertNotNull(result);
    assertNotNull(result.value());
  }
}
