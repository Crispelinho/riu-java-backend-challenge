// Este puerto queda reservado para logging técnico si se requiere en el futuro.
// Actualmente, la aplicación no debe depender de él.

package com.riu.challenge.hotel_availability_search.application.ports;

import com.riu.challenge.hotel_availability_search.domain.exceptions.LogServiceException;

public interface LogServicePort {
	void logDebug(String message);
	void logInfo(String message);
	void logWarn(String message);
	void logError(String message);
	void logError(String message, Throwable throwable) throws LogServiceException;
}
