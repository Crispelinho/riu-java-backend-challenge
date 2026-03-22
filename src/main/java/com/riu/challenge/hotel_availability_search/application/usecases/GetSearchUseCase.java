package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
public class GetSearchUseCase {
  private final SearchRepositoryPort searchRepositoryAdapter;

  public GetSearchUseCase(SearchRepositoryPort searchRepositoryAdapter) {
    this.searchRepositoryAdapter = searchRepositoryAdapter;
  }

  public Search execute(SearchId searchId) {
    return searchRepositoryAdapter.findById(searchId);
  }
}
