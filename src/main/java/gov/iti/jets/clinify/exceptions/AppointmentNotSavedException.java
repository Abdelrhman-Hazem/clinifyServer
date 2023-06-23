package gov.iti.jets.clinify.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class AppointmentNotSavedException extends RuntimeException {
	private static final long serialVersionUID = 2426256104172639927L;
	public AppointmentNotSavedException(String message)
	{
		super(message);
	}
}
