package main.plats.exceptions;

/**
 * <p>Exception lancee par la classe PlatAuMenu</p>
 */
public class PlatAuMenuException extends Exception {
    /**
     * <p>Constructeur</p>
     * @param message Message de l'exception
     */
    public PlatAuMenuException(String message) {
        super("PlatAuMenuException: " + message);
    }
}
