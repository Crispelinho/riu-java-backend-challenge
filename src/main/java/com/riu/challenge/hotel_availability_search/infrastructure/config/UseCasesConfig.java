package com.riu.challenge.hotel_availability_search.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {
    "com.riu.challenge.hotel_availability_search.application.usecases",
}, includeFilters = {
    @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
    })
}, useDefaultFilters = false)
public class UseCasesConfig {

}
