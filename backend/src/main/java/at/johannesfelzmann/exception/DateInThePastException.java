package at.johannesfelzmann.exception;

public class DateInThePastException extends RuntimeException {
    public DateInThePastException(String message) {
        super(message);
    }
}
