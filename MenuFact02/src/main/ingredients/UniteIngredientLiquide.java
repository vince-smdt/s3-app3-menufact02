package main.ingredients;

/**
 * <p>Unite d'ingredient liquide, mesuree en millilitres</p>
 */
public class UniteIngredientLiquide implements UniteIngredient {
    private final TypeUniteIngredient type;

    /**
     * <p>Constructeur</p>
     */
    public UniteIngredientLiquide() {
        this.type = TypeUniteIngredient.LIQUIDE;
    }

    /**
     * <p>Retourne le type de l'unite</p>
     * @return Le type de l'unite
     */
    public TypeUniteIngredient getType() {
        return this.type;
    }

    /**
     * <p>Retourne une String representant le type de l'unite</p>
     * @return Une String du type de l'unite
     */
    @Override
    public String toString() {
        return "ml";
    }
}
