package com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository;

import java.time.LocalDate;
import java.util.List;

import com.riu.challenge.hotel_availability_search.domain.exceptions.SearchNotFoundException;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.entities.SearchEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchRepositoryAdapter implements SearchRepositoryPort {

  private final SearchRepository searchRepository;

  @Override
  public Search save(final Search search) {
    return mapToSearch(searchRepository.save(mapToSearchEntity(search)));
  }

  @Override
  public Search findById(final SearchId searchId) {
    final SearchEntity searchEntity = searchRepository.findBySearchId(searchId.value());
    if (searchEntity == null) {
      throw new SearchNotFoundException("No se encontró la búsqueda con id: " + searchId.value());
    }
    return mapToSearch(searchEntity);
  }

  @Override
  public long countEquivalentSearches(
      final String hotelId,
      final LocalDate checkIn,
      final LocalDate checkOut,
      final List<Integer> ages) {
    final List<SearchEntity> entities = searchRepository.findByHotelIdAndCheckInDateAndCheckOutDate(hotelId, checkIn,
        checkOut);
    return entities.stream()
        .filter(e -> areAgesEqual(e.getAges(), ages))
        .count();
  }

  private boolean areAgesEqual(final List<Integer> dbAges, final List<Integer> requestAges) {
    if (dbAges == null || requestAges == null) {
      return false;
    }
    if (dbAges.size() != requestAges.size()) {
      return false;
    }
    for (int i = 0; i < dbAges.size(); i++) {
      if (!dbAges.get(i).equals(requestAges.get(i))) {
        return false;
      }
    }
    return true;
  }


  private SearchEntity mapToSearchEntity(final Search search) {
    SearchEntity searchEntity = new SearchEntity();
    searchEntity.setSearchId(search.searchId().value());
    searchEntity.setHotelId(search.hotelId());
    searchEntity.setCheckInDate(search.checkIn());
    searchEntity.setCheckOutDate(search.checkOut());
    searchEntity.setAges(search.ages());
    return searchEntity;
  }

  public Search mapToSearch(final SearchEntity searchEntity) {
    if (searchEntity == null) {
      throw new SearchNotFoundException("Entidad de búsqueda no encontrada");
    }
    return new Search(
        new SearchId(searchEntity.getSearchId()),
        searchEntity.getHotelId(),
        searchEntity.getCheckInDate(),
        searchEntity.getCheckOutDate(),
        searchEntity.getAges());
  }
}
