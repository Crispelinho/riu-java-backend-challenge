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

    public void logDebug(String component, String message) {
        if (log.isDebugEnabled()) {
            log.debug(formatMessage(component, message));
        }
    }

    @Override
    public void logInfo(String message) {
        log.info(message);
    }

    public void logInfo(String component, String message) {
        if (log.isInfoEnabled()) {
            log.info(formatMessage(component, message));
        }
    }

    @Override
    public void logWarn(String message) {
        log.warn(message);
    }

    public void logWarn(String component, String message) {
        if (log.isWarnEnabled()) {
            log.warn(formatMessage(component, message));
        }
    }

    @Override
    public void logError(String message) {
        log.error(message);
    }

    public void logError(String component, String message) {
        if (log.isErrorEnabled()) {
            log.error(formatMessage(component, message));
        }
    }

    @Override
    public void logError(String message, Throwable throwable) throws LogServiceException {
        log.error(message, throwable);
        throw new LogServiceException(message, throwable);
    }

    public void logError(String component, String message, Throwable throwable) throws LogServiceException {
        if (log.isErrorEnabled()) {
            log.error(formatMessage(component, message), throwable);
        }
        throw new LogServiceException(formatMessage(component, message), throwable);
    }

    private String formatMessage(String component, String message) {
        return "[" + component + "] " + message;
    }
}
