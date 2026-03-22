package com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.application.commands.GetSearchCommand;
import com.riu.challenge.hotel_availability_search.application.commands.GetSearchCountCommand;
import com.riu.challenge.hotel_availability_search.application.usecases.CreateSearchUseCase;
import com.riu.challenge.hotel_availability_search.application.usecases.GetSearchCountUseCase;
import com.riu.challenge.hotel_availability_search.application.usecases.GetSearchUseCase;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchCountResponseDTO;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchIdResponseDTO;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchRequestDTO;
import com.riu.challenge.hotel_availability_search.infrastructure.entrypoint.restcontroller.dto.SearchResponsetDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SearchController {

  private final CreateSearchUseCase createSearchUseCase;

  private final GetSearchCountUseCase getSearchCountUseCase;

  private final GetSearchUseCase getSearchUseCase;

  @PostMapping("/search")
  public ResponseEntity<SearchIdResponseDTO> search(@Valid @RequestBody final SearchRequestDTO request) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final LocalDate checkIn = LocalDate.parse(request.checkIn(), formatter);
    final LocalDate checkOut = LocalDate.parse(request.checkOut(), formatter);
    final List<Integer> ages = Arrays.asList(request.ages());

    final CreateSearchCommand command = new CreateSearchCommand(
        request.hotelId(),
        checkIn,
        checkOut,
        ages);

    final SearchId searchId = createSearchUseCase.execute(command).getSearchId();
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(new SearchIdResponseDTO(searchId.getValue()));
  }

  @GetMapping("count/{searchId}")
  public ResponseEntity<SearchCountResponseDTO> countSearches(@PathVariable String searchId) {
    final SearchId searchId1 = new SearchId(searchId);
    final GetSearchCommand getSearchCommand = new GetSearchCommand(searchId1);
    final Search search = getSearchUseCase.execute(getSearchCommand.searchId());
    final GetSearchCountCommand getSearchCountCommand = new GetSearchCountCommand(
        search.getHotelId(),
        search.getCheckIn(),
        search.getCheckOut(),
        search.getAges());

    final long count = getSearchCountUseCase.execute(getSearchCountCommand);
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(new SearchCountResponseDTO(
            searchId,
            new SearchResponsetDTO(
                search.getHotelId(),
                search.getCheckIn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                search.getCheckOut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                search.getAges().stream().mapToInt(Integer::intValue).toArray()
            ),
            count));
  }
}
