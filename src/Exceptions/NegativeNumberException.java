package Exceptions;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String code) {
        super(code);
    }
}
