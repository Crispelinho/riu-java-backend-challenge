// Este puerto queda reservado para logging técnico si se requiere en el futuro.
// Actualmente, la aplicación no debe depender de él.

package com.riu.challenge.hotel_availability_search.application.ports;

public interface LogServicePort {
	void logDebug(String message);
	void logDebug(String component, String message);
	void logInfo(String message);
	void logInfo(String component, String message);
	void logWarn(String message);
	void logWarn(String component, String message);
	void logError(String message);
	void logError(String component, String message);
	void logError(String message, Throwable throwable);
	void logError(String component, String message, Throwable throwable);
}
