package main.ingredients;

/**
 * <p>Ingredient de type fruit</p>
 */
public class Fruit extends Ingredient {
    /**
     * <p>Constructeur</p>
     * @param nom Nom du fruit
     * @param unite Unite pour quantifier un montant de fruit
     */
    public Fruit(String nom, UniteIngredient unite) {
        super(nom, unite, TypeIngredient.FRUIT);
    }
}
