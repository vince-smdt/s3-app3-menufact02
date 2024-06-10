package ingredients;

import ingredients.exceptions.IngredientInventaireException;

import java.util.ArrayList;
import java.util.Objects;

public class IngredientInventaire {
    static private IngredientInventaire instance;
    private final ArrayList<EntreeIngredientInventaire> entrees;
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
        if (this.entreeCourante >= this.entrees.size() - 1)
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

    public void ajouterEntree(EntreeIngredientInventaire nouvelleEntree) {
        // Applying flyweight, checking if ingredient already exists.
        // If ingredient already exists, we only update the quantity.
        // Otherwise, the whole entry is added in the list.
        Ingredient nouvelIngredient = nouvelleEntree.getIngredient();

        for (EntreeIngredientInventaire entree : this.entrees) {
            Ingredient ingredient = entree.getIngredient();

            // Check if same ingredient
            if (Objects.equals(ingredient.getNom(), nouvelIngredient.getNom())
                &&  ingredient.getType() == nouvelIngredient.getType()
                &&  ingredient.getUnite().getType() == nouvelIngredient.getUnite().getType()
            ) {
                // Update quantity of existing item
                entree.setQuantite(nouvelleEntree.getQuantite());
                return;
            }
        }

        // Ingredient doesn't already exist, adding new entry
        this.entrees.add(nouvelleEntree);
    }

    public void viderInventaire() {
        this.entrees.clear();
        this.entreeCourante = 0;
    }

    public int getNombreEntrees() {
        return this.entrees.size();
    }
}
