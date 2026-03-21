package com.riu.challenge.hotel_availability_search.infrastructure.config;

import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.SearchRepository;
import com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository.SearchRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.riu.challenge.hotel_availability_search.domain.ports.SearchRepositoryPort;

@Configuration
@ComponentScan(basePackages = {
    "com.riu.challenge.hotel_availability_search.domain.ports",
}, includeFilters = {
    @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Adapter$")
}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
    })
}, useDefaultFilters = false)
public class PortsConfig {
    @Bean
    public SearchRepositoryPort searchRepositoryPort(
            SearchRepository searchRepository) {
        return new SearchRepositoryAdapter(searchRepository);
    }
}
