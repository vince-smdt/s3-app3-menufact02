package main.ingredients;

public class UniteIngredientLiquide implements UniteIngredient {
    private final TypeUniteIngredient type;

    public UniteIngredientLiquide() {
        this.type = TypeUniteIngredient.LIQUIDE;
    }

    public TypeUniteIngredient getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "ml";
    }
}
