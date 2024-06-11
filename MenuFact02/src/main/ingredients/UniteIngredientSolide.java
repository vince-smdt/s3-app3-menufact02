package main.ingredients;

/**
 * <p>Unite de l'ingredient solide</p>
 */
public class UniteIngredientSolide implements UniteIngredient {
    private final TypeUniteIngredient type;

    /**
     * <p>Constructeur</p>
     */
    public UniteIngredientSolide() {
        this.type = TypeUniteIngredient.SOLIDE;
    }

    /**
     * <p>Retourne le type de l'unite</p>
     * @return Le type de l'unite
     */
    public TypeUniteIngredient getType() {
        return this.type;
    }

    /**
     * <p>Retourne une String du type de l'unite</p>
     * @return String du type de l'unite
     */
    @Override
    public String toString() {
        return "g";
    }
}
