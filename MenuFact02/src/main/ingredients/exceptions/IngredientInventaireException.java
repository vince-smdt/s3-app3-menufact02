package main.ingredients.exceptions;

/**
 * <p>Exception lancee par la classe IngredientInventaire</p>
 */
public class IngredientInventaireException extends Exception {
    /**
     * <p>Constructeur</p>
     * @param message Message de l'exception
     */
    public IngredientInventaireException(String message) {
        super("IngredientInventaireException: " + message);
    }
}
