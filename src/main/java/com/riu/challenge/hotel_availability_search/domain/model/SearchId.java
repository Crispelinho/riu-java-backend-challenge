package com.riu.challenge.hotel_availability_search.domain.model;

import java.util.UUID;

import lombok.Data;

@Data
public class SearchId{

  private String value;

  public SearchId(String value) {
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException("searchId cannot be null or blank");
    }
    this.value = value;
  }

  public static SearchId generate() {
    return new SearchId(UUID.randomUUID().toString());
  }

}
