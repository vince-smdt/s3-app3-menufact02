package main.ingredients;

/**
 * <p>Un ingredient pouvant faire partie d'un plat, et pouvant etre stocke dans l'inventaire</p>
 */
public class Ingredient {
    private final String nom;
    private final UniteIngredient unite;
    private final TypeIngredient type;

    /**
     * <p>Constructeur</p>
     * @param nom Nom de l'ingredient
     * @param unite Unite pour quantifier l'ingredient
     * @param type Type de l'ingredient
     */
    public Ingredient(String nom, UniteIngredient unite, TypeIngredient type) {
        this.nom = nom;
        this.unite = unite;
        this.type = type;
    }

    /**
     * <p>Retourne le nom de l'ingredient</p>
     * @return Nom de l'ingredient
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * <p>Retourne l'unite de l'ingredient</p>
     * @return L'unite de l'ingredient
     */
    public UniteIngredient getUnite() {
        return this.unite;
    }

    /**
     * <p>Retourne le type de l'ingredient</p>
     * @return Le type de l'ingredient
     */
    public TypeIngredient getType() {
        return this.type;
    }
}
