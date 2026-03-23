package com.riu.challenge.hotel_availability_search.application.usecases;

import com.riu.challenge.hotel_availability_search.application.commands.CreateSearchCommand;
import com.riu.challenge.hotel_availability_search.domain.model.Search;
import com.riu.challenge.hotel_availability_search.domain.model.SearchId;
import com.riu.challenge.hotel_availability_search.application.ports.NotificationServicePort;
public class CreateSearchUseCase {
  private final NotificationServicePort notificationServicePort;

  public CreateSearchUseCase(NotificationServicePort notificationServicePort) {
    this.notificationServicePort = notificationServicePort;
  }

  public SearchId execute(final CreateSearchCommand createSearchCommand) {
    Search search = mapToSearch(createSearchCommand);
    notificationServicePort.publishSearchCreatedEvent(search);
    return search.searchId();
  }

  private Search mapToSearch(final CreateSearchCommand createSearchCommand) {
    return new Search(
        SearchId.generate(),
        createSearchCommand.hotelId(),
        createSearchCommand.checkIn(),
        createSearchCommand.checkOut(),
        createSearchCommand.ages()
    );
  }
}
