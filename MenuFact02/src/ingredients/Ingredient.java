package ingredients;

public class Ingredient {
    private final String nom;
    private final UniteIngredient unite;
    private final TypeIngredient type;

    public Ingredient(String nom, UniteIngredient unite, TypeIngredient type) {
        this.nom = nom;
        this.unite = unite;
        this.type = type;
    }

    public String getNom() {
        return this.nom;
    }

    public UniteIngredient getUnite() {
        return this.unite;
    }

    public TypeIngredient getType() {
        return this.type;
    }
}
