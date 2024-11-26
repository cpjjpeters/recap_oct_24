package be.ipeters.recap.common.exception;


import be.ipeters.recap.customer.CustomerAlreadyExistsException;
import be.ipeters.recap.customer.NoSuchCustomerExistsException;
import be.ipeters.recap.error.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoSuchCustomerExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleException(NoSuchCustomerExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Exception Handler method added in CustomerController to handle CustomerAlreadyExistsException
    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

//    @ExceptionHandler(NoSuchCustomerExistsException.class)
//    public ResponseEntity<ErrorResponse> handleMyException(NoSuchCustomerExistsException ex) {
//        ErrorResponse response = new ErrorResponse("My error message");
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler({ AccessDeniedException.class })
//    public ResponseEntity<Object> handleAccessDeniedException(
//            Exception ex, WebRequest request) {
//        return new ResponseEntity<Object>(
//                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
//    }

//    @ExceptionHandler(MyException.class)
//    public ResponseEntity<ErrorResponse> handleMyException(MyException ex) {
//        ErrorResponse response = new ErrorResponse("My error message");
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(NoSuchCityExistsException.class)
//    public NoSuchCityExistsException<?> handleException(Exception ex) {
//        ErrorResponse response = new ErrorResponse("Internal server error");
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
