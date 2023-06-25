package gov.iti.jets.clinify.exceptions;

import gov.iti.jets.clinify.utils.MessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;


@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger log = LogManager.getLogger(ControllerExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> globalExceptionHandler(Exception ex) {
        log.error(ex.getMessage());

        return new ResponseEntity<>(new MessageResponse("An error has occurred please try again later"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<MessageResponse> globalExceptionHandler(ItemNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new MessageResponse(ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponse> globalExceptionHandler(MethodArgumentNotValidException ex) {
        MessageResponse messageResponse = new MessageResponse(Objects.requireNonNull(ex.getFieldError()).getDefaultMessage());
        messageResponse.setField(ex.getFieldError().getField());

        log.error(ex.getFieldError());
        return new ResponseEntity<>(messageResponse,
                HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(FieldNotUniqueException.class)
    public ResponseEntity<MessageResponse> globalExceptionHandler(FieldNotUniqueException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new MessageResponse(ex.getMessage(),ex.getField()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AppointmentNotSavedException.class)
    public ResponseEntity<MessageResponse> globalExceptionHandler(AppointmentNotSavedException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new MessageResponse(ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
