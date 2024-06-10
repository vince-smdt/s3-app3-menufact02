package ingredients;

public class IngredientPlat {
    private Ingredient ingredient;
    private int quantite;

    public IngredientPlat(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public int getQuantite() {
        return this.quantite;
    }
}
