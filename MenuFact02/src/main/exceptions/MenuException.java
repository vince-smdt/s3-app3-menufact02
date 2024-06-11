package main.exceptions;

/**
 * <p>Exception lancee par la classe Menu</p>
 */
public class MenuException extends Exception{
    /**
     * <p>Constructeur</p>
     * @param message Message de l'exception
     */
    public MenuException(String message){
        super("MenuException: " + message);
    }
}

