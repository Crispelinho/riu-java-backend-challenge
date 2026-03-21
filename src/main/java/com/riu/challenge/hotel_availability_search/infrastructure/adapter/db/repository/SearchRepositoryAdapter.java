package com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository;

import java.util.List;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.entities.SearchEntity;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.protocol.types.Field.Str;

@AllArgsConstructor
public class SearchRepositoryAdapter implements SearchRepositoryPort {

  private final SearchRepository searchRepository;

  @Override
  public Search save(final Search search) {
    return mapToSearch(searchRepository.save(mapToSearchEntity(search)));
  }

  @Override
  public long countByHotelIdAndCheckInAndCheckOutAndAges(final String searchId) {
    final SearchEntity searchEntity = searchRepository.findBySearchId(searchId);
    return searchRepository.countByHotelIdAndCheckInAndCheckOutAndAges(
        searchEntity.getHotelId(),
        searchEntity.getCheckIn(),
        searchEntity.getCheckOut(),
        searchEntity.getAges()
    );
  }

  private SearchEntity mapToSearchEntity(final Search search) {
    final SearchEntity searchEntity = new SearchEntity();
    searchEntity.setSearchId(search.getSearchId().getValue());
    searchEntity.setHotelId(search.getHotelId());
    searchEntity.setCheckIn(search.getCheckIn());
    searchEntity.setCheckOut(search.getCheckOut());
    searchEntity.setAges(search.getAges());
    return searchEntity;
  }

  public Search mapToSearch(final SearchEntity searchEntity) {
    final SearchId searchId = new SearchId(searchEntity.getSearchId());
    return new Search(
        searchId,
        searchEntity.getHotelId(),
        searchEntity.getCheckIn(),
        searchEntity.getCheckOut(),
        searchEntity.getAges()
    );
  }
}
