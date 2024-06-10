package ingredients;

import ingredients.exceptions.IngredientInventaireException;

import java.util.ArrayList;

public class IngredientInventaire {
    static private IngredientInventaire instance;
    private ArrayList<EntreeIngredientInventaire> entrees;
    private int entreeCourante;

    private IngredientInventaire() {
        this.entrees = new ArrayList<EntreeIngredientInventaire>();
        this.entreeCourante = 0;
    }

    static public IngredientInventaire getInstance() {
        if (instance == null) {
            instance = new IngredientInventaire();
        }
        return instance;
    }

    public void entreeSuivante() throws IngredientInventaireException {
        if (this.entreeCourante >= this.entrees.size())
            throw new IngredientInventaireException("Depassement du nombre maximal d'entrees.");

        this.entreeCourante++;
    }

    public void entreePrecedente() throws IngredientInventaireException {
        if (this.entreeCourante <= 0)
            throw new IngredientInventaireException("Depassement du nombre minimal d'entrees.");

        this.entreeCourante--;
    }

    public EntreeIngredientInventaire getEntreeCourante() {
        return this.entrees.get(this.entreeCourante);
    }
}
