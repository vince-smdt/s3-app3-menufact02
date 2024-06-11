package main.ingredients;

import main.ingredients.exceptions.EntreeIngredientInventaireException;

/**
 * <p>Une entree dans l'inventaire des ingredients, representant un ingrediant et sa quantite dans
 * l'inventaire.</p>
 */
public class EntreeIngredientInventaire {
    private final Ingredient ingredient;
    private int quantite;

    /**
     * <p>Constructeur</p>
     * @param ingredient L'ingredient dans l'inventaire
     * @param quantite La quantite de l'ingredient (l'unite est specifie par l'ingredient)
     */
    public EntreeIngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        this.quantite = quantite;
    }

    /**
     * <p>Retourne l'ingredient</p>
     * @return L'ingredient de l'entree dans l'inventaire
     */
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    /**
     * <p>Retourne la quanitte</p>
     * @return La quantite de l'ingredient dans l'entree dans l'inventaire
     */
    public int getQuantite() {
        return this.quantite;
    }

    /**
     * <p>Specifie la quantite</p>
     * @param quantite La quantite de l'ingredient de l'entree dans l'inventaire
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * <p>Utilise un certain montant de l'ingredient dans l'inventaire, soustrayant une certaine
     * quantite de l'inventaire</p>
     * @param quantite Quantite de l'ingredient a utiliser
     * @throws EntreeIngredientInventaireException Lorsque la quantite a utiliser est plus grande que le montant restant
     */
    public void utiliser(int quantite) throws EntreeIngredientInventaireException {
        if (quantite > this.quantite)
            throw new EntreeIngredientInventaireException("Quantite insuffisante d'ingredient a utiliser.");

        this.quantite -= quantite;
    }

    /**
     * <p>Ajoute un certain montant de l'ingredient dans l'inventaire</p>
     * @param quantite Quantite de l'ingredient a ajouter dans l'inventaire
     */
    public void ajouter(int quantite) {
        this.quantite += quantite;
    }
}
