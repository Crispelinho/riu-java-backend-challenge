package com.riu.challenge.hotel_availability_search.infrastructure.adapter.service;

import com.riu.challenge.hotel_availability_search.application.ports.LogServicePort;
import org.slf4j.Logger;

import com.riu.challenge.hotel_availability_search.domain.exceptions.LogServiceException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogServiceAdapter implements LogServicePort {
    private static final Logger log = LoggerFactory.getLogger(LogServiceAdapter.class);

    @Override
    public void logDebug(String message) {
        log.debug(message);
    }

    @Override
    public void logInfo(String message) {
        log.info(message);
    }

    @Override
    public void logWarn(String message) {
        log.warn(message);
    }

    @Override
    public void logError(String message) {
        log.error(message);
    }

    @Override
    public void logError(String message, Throwable throwable) throws LogServiceException {
        log.error(message, throwable);
        throw new LogServiceException(message, throwable);
    }
}
