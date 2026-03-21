package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.application.usecases.CreateSearchUseCase;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchCountResponseDTO;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchRequestDTO;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SearchController {

  private final CreateSearchUseCase createSearchUseCase;

  @PostMapping("/search")
  public ResponseEntity<SearchResponseDTO> search(@Valid @RequestBody final SearchRequestDTO request) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final LocalDate checkIn = LocalDate.parse(request.checkIn(), formatter);
    final LocalDate checkOut = LocalDate.parse(request.checkOut(), formatter);
    final List<Integer> ages = Arrays.asList(request.ages());

    final CreateSearchCommand command = new CreateSearchCommand(
        request.hotelId(),
        checkIn,
        checkOut,
        ages
    );

    final SearchId searchId = createSearchUseCase.execute(command).getSearchId();
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(new SearchResponseDTO(searchId.getValue()));
  }

  @GetMapping("count/{searchId}")
  public ResponseEntity<SearchCountResponseDTO> countSearches(@Valid @RequestBody final String searchId) {

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(new SearchCountResponseDTO(
            searchId, null, null
        ));
  }
}
