package main.ingredients;

public class UniteIngredientSolide implements UniteIngredient {
    private final TypeUniteIngredient type;

    public UniteIngredientSolide() {
        this.type = TypeUniteIngredient.SOLIDE;
    }

    public TypeUniteIngredient getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "g";
    }
}
