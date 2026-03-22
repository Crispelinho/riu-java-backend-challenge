package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.application.usecases.CreateSearchUseCase;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SearchControllerTest {
    @Test
    void searchReturnsResponseWithId() {
        CreateSearchUseCase useCase = mock(CreateSearchUseCase.class);
        SearchController controller = new SearchController(useCase, null, null);
        SearchRequestDTO dto = new SearchRequestDTO("H1", "01/01/2026", "02/01/2026", new Integer[]{1,2});
        ResponseEntity<?> response = controller.search(dto);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
    }
}
