package main.ingredients.exceptions;

public class EntreeIngredientInventaireException extends Exception {
    public EntreeIngredientInventaireException(String message) {
        super ("EntreeIngredientInventaireException: " + message);
    }
}
