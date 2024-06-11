package main.ingredients;

/**
 * <p>Ingredient de type viande</p>
 */
public class Viande extends Ingredient {
    /**
     * <p>Constructeur</p>
     * @param nom Nom de l'ingredient de type viande
     * @param unite L'unite de l'ingredient de type viande
     */
    public Viande(String nom, UniteIngredient unite) {
        super(nom, unite, TypeIngredient.VIANDE);
    }
}
