package main.ingredients;

import main.ingredients.exceptions.IngredientInventaireException;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <p>L'inventaire contenant toutes les entrees d'ingredient, est un singleton puisque le
 * restaurant n'a qu'un seul inventaire pour tout ses ingredients.</p>
 */
public class IngredientInventaire {
    static private IngredientInventaire instance;
    private final ArrayList<EntreeIngredientInventaire> entrees;
    private int entreeCourante;

    /**
     * <p>Constructeur</p>
     */
    private IngredientInventaire() {
        this.entrees = new ArrayList<EntreeIngredientInventaire>();
        this.entreeCourante = 0;
    }

    /**
     * <p>Retourne l'instance singuliere du singleton</p>
     * @return L'instance du singleton IngredientInventaire
     */
    static public IngredientInventaire getInstance() {
        if (instance == null) {
            instance = new IngredientInventaire();
        }
        return instance;
    }

    /**
     * <p>Avance l'index de l'entree d'ingredient courant a la prochaine entree</p>
     * @throws IngredientInventaireException Si l'index depasse le nombre d'entrees dans l'inventaire
     */
    public void entreeSuivante() throws IngredientInventaireException {
        if (this.entreeCourante >= this.entrees.size() - 1)
            throw new IngredientInventaireException("Depassement du nombre maximal d'entrees.");

        this.entreeCourante++;
    }

    /**
     * <p>Recule l'index de l'entree d'ingredient courant</p>
     * @throws IngredientInventaireException Si l'index recule derriere le nombre minimal d'entrees
     */
    public void entreePrecedente() throws IngredientInventaireException {
        if (this.entreeCourante <= 0)
            throw new IngredientInventaireException("Depassement du nombre minimal d'entrees.");

        this.entreeCourante--;
    }

    /**
     * <p>Retourne l'entree pointee par l'index d'entree courant</p>
     * @return L'entree courante
     */
    public EntreeIngredientInventaire getEntreeCourante() {
        return this.entrees.get(this.entreeCourante);
    }

    /**
     * <p>Rajoute une entree dans l'inventaire</p>
     * @param nouvelleEntree L'entree a rajouter a l'inventaire
     */
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

    /**
     * <p>Vide toutes les entrees de l'inventaire</p>
     */
    public void viderInventaire() {
        this.entrees.clear();
        this.entreeCourante = 0;
    }

    /**
     * Retourne le nombre d'entrees dans l'inventaire
     * @return le nombre d'entrees
     */
    public int getNombreEntrees() {
        return this.entrees.size();
    }
}
