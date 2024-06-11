package main.ingredients.exceptions;

/**
 * <p>Exception lancee par la class EntreeIngredientInventaire</p>
 */
public class EntreeIngredientInventaireException extends Exception {
    /**
     * <p>Constructeur</p>
     * @param message Message de l'exception
     */
    public EntreeIngredientInventaireException(String message) {
        super ("EntreeIngredientInventaireException: " + message);
    }
}
