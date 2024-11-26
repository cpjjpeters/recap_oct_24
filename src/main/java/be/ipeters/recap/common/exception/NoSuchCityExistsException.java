package be.ipeters.recap.common.exception;

public class NoSuchCityExistsException extends RuntimeException{
    private String message;

    public NoSuchCityExistsException() {
    }
    public NoSuchCityExistsException(String message) {
        super(message);
        this.message = message;
    }

}
