package com.riu.challenge.hotel_availability_search.infrastructure.adapter.service;

import com.riu.challenge.hotel_availability_search.application.ports.LogServicePort;
import com.riu.challenge.hotel_availability_search.domain.exceptions.LogServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogServiceAdapterTest {
    private final LogServicePort logService = new LogServiceAdapter();

    @Test
    void logDebugDoesNotThrow() {
        assertDoesNotThrow(() -> logService.logDebug("debug message"));
    }

    @Test
    void logInfoDoesNotThrow() {
        assertDoesNotThrow(() -> logService.logInfo("info message"));
    }

    @Test
    void logWarnDoesNotThrow() {
        assertDoesNotThrow(() -> logService.logWarn("warn message"));
    }

    @Test
    void logErrorMessageOnlyDoesNotThrow() {
        assertDoesNotThrow(() -> logService.logError("error message"));
    }

    @Test
    void logErrorWithThrowableThrowsLogServiceExceptionAndEncapsulatesCause() {
        Exception original = new IllegalArgumentException("original");
        LogServiceException thrown = assertThrows(LogServiceException.class, () -> logService.logError("error with cause", original));
        assertEquals("error with cause", thrown.getMessage());
        assertSame(original, thrown.getCause());
    }
}
