package be.ipeters.recap.common.exception;

/* carlpeters created on 21/11/2024 inside the package - be.ipeters.recap.common.exception */

public class CityAlreadyExistsException  extends RuntimeException {
    // Creating a custom exception that can be thrown when a user tries to add a city that already exists

     private String message;

        public CityAlreadyExistsException() {}

        public CityAlreadyExistsException(String msg) {
            super(msg);
            this.message = msg;
        }
    }