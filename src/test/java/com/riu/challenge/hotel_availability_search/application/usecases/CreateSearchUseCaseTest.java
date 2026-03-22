package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.application.ports.NotificationServicePort;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.mockito.Mockito.*;

class CreateSearchUseCaseTest {
    @Test
    void executePublishesEvent() {
        NotificationServicePort notificationServicePort = mock(NotificationServicePort.class);
        CreateSearchCommand cmd = new CreateSearchCommand("H1", LocalDate.now(), LocalDate.now().plusDays(1), List.of(1,2));
        CreateSearchUseCase useCase = new CreateSearchUseCase(notificationServicePort);
        useCase.execute(cmd);
        verify(notificationServicePort).publishSearchCreatedEvent(any(Search.class));
    }
}
