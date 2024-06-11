package main.plats;

import java.util.ArrayList;
import main.ingredients.IngredientPlat;
import main.plats.exceptions.PlatAuMenuException;

/**
 * <p>Un plat sur un menu</p>
 */
public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private int ingredientCourant;
    private ArrayList<IngredientPlat> ingredients;

    /**
     * <p>Constructeur</p>
     * @param code Code du plat
     * @param description Description du plat
     * @param prix Prix du plat
     */
    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.ingredientCourant = 0;
        this.ingredients = new ArrayList<IngredientPlat>();
    }

    /**
     * <p>Retourne une String contenant les informations du plat au menu</p>
     * @return Une String contenant les informations du plat
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    /**
     * <p>Retourne le code du plat</p>
     * @return Le code du plat
     */
    public int getCode() {
        return code;
    }

    /**
     * <p>Retourne la description du plat</p>
     * @return La description du plat
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>Retourne le prix du plat</p>
     * @return Le prix du plat
     */
    public double getPrix() {
        return prix;
    }

    /**
     * <p>Avance vers l'ingredient suivant du plat</p>
     * @throws PlatAuMenuException Si l'index depasse le nombre maximal d'ingredients dans le plat
     */
    public void ingredientSuivant() throws PlatAuMenuException {
        if (this.ingredientCourant >= this.ingredients.size())
            throw new PlatAuMenuException("Depassement du montant maximal d'ingredients.");

        this.ingredientCourant++;
    }

    /**
     * <p>Recule vers l'ingredient precedent du plat</p>
     * @throws PlatAuMenuException Si l'index depasse le nombre minimal d'ingredients dans le plat
     */
    public void ingredientPrecedent() throws PlatAuMenuException {
        if (this.ingredientCourant <= 0)
            throw new PlatAuMenuException("Depassement du montant minimal d'ingredients.");

        this.ingredientCourant--;
    }

    /**
     * <p>Retourne l'ingredient courant du plat, selectionne par l'index</p>
     * @return L'ingredient courant
     */
    public IngredientPlat getIngredientCourant() {
        return this.ingredients.get(this.ingredientCourant);
    }

    /**
     * <p>Ajoute un ingredient au plat</p>
     * @param ingredient L'ingredient a rajouter au plat
     */
    public void ajouterIngredient(IngredientPlat ingredient) {
        this.ingredients.add(ingredient);
    }
}
