package main.ingredients;

/**
 * <p>Ingredient de type legume</p>
 */
public class Legume extends Ingredient {
    /**
     * <p>Constructeur</p>
     * @param nom Nom de l'ingredient de type legume
     * @param unite L'unite pour quantifier le legume
     */
    public Legume(String nom, UniteIngredient unite) {
        super(nom, unite, TypeIngredient.LEGUME);
    }
}
