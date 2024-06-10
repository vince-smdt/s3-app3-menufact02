package plats;

import java.util.ArrayList;
import ingredients.IngredientPlat;
import plats.exceptions.PlatAuMenuException;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private int ingredientCourant;
    private ArrayList<IngredientPlat> ingredients;

    public PlatAuMenu(int code, String description, double prix) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.ingredientCourant = 0;
        this.ingredients = new ArrayList<IngredientPlat>();
    }

    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void ingredientSuivant() throws PlatAuMenuException {
        if (this.ingredientCourant >= this.ingredients.size())
            throw new PlatAuMenuException("Depassement du montant maximal d'ingredients.");

        this.ingredientCourant++;
    }

    public void ingredientPrecedent() throws PlatAuMenuException {
        if (this.ingredientCourant <= 0)
            throw new PlatAuMenuException("Depassement du montant minimal d'ingredients.");

        this.ingredientCourant--;
    }

    public IngredientPlat getIngredientCourant() {
        return this.ingredients.get(this.ingredientCourant);
    }
}
