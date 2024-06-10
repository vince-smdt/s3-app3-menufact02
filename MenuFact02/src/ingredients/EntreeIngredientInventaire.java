package ingredients;

import ingredients.exceptions.EntreeIngredientInventaireException;

public class EntreeIngredientInventaire {
    private final Ingredient ingredient;
    private int quantite;

    public EntreeIngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void utiliser(int quantite) throws EntreeIngredientInventaireException {
        if (quantite > this.quantite)
            throw new EntreeIngredientInventaireException("Quantite insuffisante d'ingredient a utiliser.");

        this.quantite -= quantite;
    }

    public void ajouter(int quantite) {
        this.quantite += quantite;
    }
}
