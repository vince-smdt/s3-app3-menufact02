package plats.exceptions;

public class PlatAuMenuException extends Exception {
    public PlatAuMenuException(String message) {
        super("PlatAuMenuException: " + message);
    }
}
