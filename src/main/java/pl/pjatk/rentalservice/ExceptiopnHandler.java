package pl.pjatk.rentalservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.time.Instant;

public class ExceptiopnHandler {

    @ControllerAdvice
    public class TaskExceptionHandler {
        @ExceptionHandler(ConnectException.class)
        @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
        public ResponseEntity<Object> helloConnectException(ConnectException exception) {
            return new ResponseEntity<>(new Error(HttpStatus.GATEWAY_TIMEOUT.value(), exception.toString(), Instant.now()), HttpStatus.GATEWAY_TIMEOUT);
        }


        @ExceptionHandler(HttpServerErrorException.class)
        @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
        public ResponseEntity<Object> helloInternalException(HttpServerErrorException exception) {
            if (exception.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR))
                return new ResponseEntity<>(new Error(HttpStatus.BAD_GATEWAY.value(), exception.toString(), Instant.now()), HttpStatus.BAD_GATEWAY);
            return ResponseEntity.ok().build();
        }

        @ExceptionHandler(HttpClientErrorException.class)
        public ResponseEntity<Object> hello_400_errors(HttpClientErrorException exception) {
            if (exception.getStatusCode().equals(HttpStatus.NOT_FOUND))
                return new ResponseEntity<>(new Error(HttpStatus.NOT_FOUND.value(), exception.toString(), Instant.now()), HttpStatus.NOT_FOUND);
            if (exception.getStatusCode().equals(HttpStatus.BAD_REQUEST))
                return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(), exception.toString(), Instant.now()), HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok().build();
        }
    }
}
