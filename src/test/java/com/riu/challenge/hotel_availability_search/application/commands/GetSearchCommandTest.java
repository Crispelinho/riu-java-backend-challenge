package com.riu.challenge.hotel_availability_search.application.commands;

import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetSearchCommandTest {
    @Test
    void storesSearchId() {
        SearchId id = new SearchId("abc");
        GetSearchCommand cmd = new GetSearchCommand(id);
        assertEquals(id, cmd.searchId());
    }
}
