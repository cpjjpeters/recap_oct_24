package be.ipeters.recap.error;

/* carlpeters created on 21/11/2022 inside the package - be.ipeters.crudapplication.error */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

// https://devwithus.com/exception-handling-spring-boot-rest-api/