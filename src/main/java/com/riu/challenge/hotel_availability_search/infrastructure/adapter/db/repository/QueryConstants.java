package com.riu.challenge.hotel_availability_search.infrastructure.adapter.db.repository;

public class QueryConstants {
    public static final String COUNT_EQUIVALENT_SEARCHES =
        "SELECT COUNT(DISTINCT s.id) " +
        "FROM searches s " +
        "JOIN search_entity_ages a ON a.search_entity_id = s.id " +
        "WHERE s.hotel_id = :hotelId " +
        "AND s.check_in_date = :checkIn " +
        "AND s.check_out_date = :checkOut " +
        "AND a.ages IN (:ages)";
}
