package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetSearchUseCaseTest {
    @Test
    void executeReturnsSearchFromRepository() {
        SearchRepositoryPort repo = mock(SearchRepositoryPort.class);
        SearchId id = SearchId.generate();
        Search expected = new Search(id, "H1", LocalDate.now(), LocalDate.now().plusDays(1), List.of(1,2));
        when(repo.findById(id)).thenReturn(expected);
        GetSearchUseCase useCase = new GetSearchUseCase(repo);
        Search result = useCase.execute(id);
        assertSame(expected, result);
        verify(repo).findById(id);
    }
}
