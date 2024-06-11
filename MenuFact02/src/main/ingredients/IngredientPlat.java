package main.ingredients;

/**
 * <p>Un ingredient dans un plat, et sa quantite utilisee dans le plat</p>
 */
public class IngredientPlat {
    private Ingredient ingredient;
    private int quantite;

    /**
     * <p>Constructeur</p>
     * @param ingredient Ingredient dans le plat
     * @param quantite Quantite de l'ingredient dans le plat
     */
    public IngredientPlat(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    /**
     * <p>Retourne l'ingredient</p>
     * @return l'ingredient
     */
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    /**
     * <p>Retourne la quantite de l'ingredient dans le plat</p>
     * @return la quantite de l'ingredient dans le plat
     */
    public int getQuantite() {
        return this.quantite;
    }
}
