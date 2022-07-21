package Exceptions;

public class IncorrectItemException extends RuntimeException{
    public IncorrectItemException() {
        super();
    }
    public IncorrectItemException(String message) {
        super(message);
    }
}
