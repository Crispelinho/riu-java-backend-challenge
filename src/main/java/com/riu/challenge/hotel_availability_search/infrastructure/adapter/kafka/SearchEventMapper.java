package com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka;

import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.kafka.event.CreateSearchEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SearchEventMapper {
    SearchEventMapper INSTANCE = Mappers.getMapper(SearchEventMapper.class);

    @Mapping(target = "searchId", expression = "java(search.searchId().value())")
    CreateSearchEvent toCreateSearchEvent(Search search);

    @Mapping(target = "searchId", expression = "java(new com.riu.challenge.hotel_availability_search.domain.model.SearchId(event.getSearchId()))")
    Search toSearch(CreateSearchEvent event);
}
