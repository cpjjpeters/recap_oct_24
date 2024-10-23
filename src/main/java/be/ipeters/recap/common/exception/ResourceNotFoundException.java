package be.ipeters.recap.common.exception;

/* carlpeters created on 23/10/2024 inside the package - be.ipeters.recap.common.exception */


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
