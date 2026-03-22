package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.application.commands.GetSearchCountCommand;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
public class GetSearchCountUseCase {
  private final SearchRepositoryPort searchRepositoryAdapter;

  public GetSearchCountUseCase(SearchRepositoryPort searchRepositoryAdapter) {
    this.searchRepositoryAdapter = searchRepositoryAdapter;
  }

  public long execute(final GetSearchCountCommand getSearchCountCommand) {
    return searchRepositoryAdapter.countEquivalentSearches(
        getSearchCountCommand.hotelId(),
        getSearchCountCommand.checkIn(),
        getSearchCountCommand.checkOut(),
        getSearchCountCommand.ages()
    );
  }
}
