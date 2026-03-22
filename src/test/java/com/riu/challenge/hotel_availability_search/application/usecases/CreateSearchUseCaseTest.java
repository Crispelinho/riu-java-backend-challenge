package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateSearchUseCaseTest {
    @Test
    void executeSavesMappedSearch() {
        SearchRepositoryPort repo = mock(SearchRepositoryPort.class);
        CreateSearchCommand cmd = new CreateSearchCommand("H1", LocalDate.now(), LocalDate.now().plusDays(1), List.of(1,2));
        when(repo.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        CreateSearchUseCase useCase = new CreateSearchUseCase(repo);
        Search result = useCase.execute(cmd);
        assertNotNull(result);
        assertEquals("H1", result.getHotelId());
        verify(repo).save(any());
    }
}
