package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateSearchUseCase {

  private final SearchRepositoryPort searchRepositoryAdapter;

  public Search execute(final CreateSearchCommand createSearchCommand) {
    return searchRepositoryAdapter.save(mapToSearch(createSearchCommand));
  }

  private Search mapToSearch(final CreateSearchCommand createSearchCommand) {
    System.out.println("Mapping CreateSearchCommand to Search"+ SearchId.generate());
    return new Search(
        SearchId.generate(),
        createSearchCommand.hotelId(),
        createSearchCommand.checkIn(),
        createSearchCommand.checkOut(),
        createSearchCommand.ages()
    );
  }
}
