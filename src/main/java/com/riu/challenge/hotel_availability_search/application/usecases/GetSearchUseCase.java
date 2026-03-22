package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetSearchUseCase {

  private final SearchRepositoryPort searchRepositoryAdapter;

  public Search execute(SearchId searchId) {
    return searchRepositoryAdapter.findById(searchId);
  }
}
