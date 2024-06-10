package ingredients.exceptions;

public class IngredientInventaireException extends Exception {
    public IngredientInventaireException(String message) {
        super("IngredientInventaireException: " + message);
    }
}
