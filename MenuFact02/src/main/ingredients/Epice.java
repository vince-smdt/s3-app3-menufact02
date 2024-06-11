package main.ingredients;

/**
 * <p>Ingredient de type epice</p>
 */
public class Epice extends Ingredient {
    /**
     * <p>Constrcteur</p>
     * @param nom Nom de l'epice
     * @param unite L'unite utiliser pour quantifier l'epice
     */
    public Epice(String nom, UniteIngredient unite) {
        super(nom, unite, TypeIngredient.EPICE);
    }
}
