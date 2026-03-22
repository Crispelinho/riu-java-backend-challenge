package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.application.commands.GetSearchCountCommand;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetSearchCountUseCaseTest {
    @Test
    void executeReturnsCountFromRepository() {
        SearchRepositoryPort repo = mock(SearchRepositoryPort.class);
        GetSearchCountCommand cmd = new GetSearchCountCommand("H1", LocalDate.now(), LocalDate.now().plusDays(1), List.of(1,2));
        when(repo.countEquivalentSearches(any(), any(), any(), any())).thenReturn(5L);
        GetSearchCountUseCase useCase = new GetSearchCountUseCase(repo);
        long count = useCase.execute(cmd);
        assertEquals(5L, count);
        verify(repo).countEquivalentSearches(eq("H1"), any(), any(), any());
    }
}
