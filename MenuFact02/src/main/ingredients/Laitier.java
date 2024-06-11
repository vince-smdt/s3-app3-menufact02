package main.ingredients;

/**
 * <p>Ingredient de type laitier</p>
 */
public class Laitier extends Ingredient {
    /**
     * <p>Constructeur</p>
     * @param nom Nom de l'ingredient laitier
     * @param unite Unite pour quantifier l'ingredient de type laitier
     */
    public Laitier(String nom, UniteIngredient unite) {
        super(nom, unite, TypeIngredient.LAITIER);
    }
}
