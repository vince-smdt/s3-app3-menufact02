package ingredients;

import main.ingredients.EntreeIngredientInventaire;
import main.ingredients.Ingredient;
import main.ingredients.Laitier;
import main.ingredients.UniteIngredientSolide;
import main.ingredients.exceptions.EntreeIngredientInventaireException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntreeIngredientInventaireTest {
    @Test
    void utiliserPartOfQuantity() {
        Ingredient ingredient = new Laitier("Fromage", new UniteIngredientSolide());
        EntreeIngredientInventaire entree = new EntreeIngredientInventaire(ingredient, 1000);
        assertDoesNotThrow(() -> { entree.utiliser(300); });
        assertEquals(700, entree.getQuantite());
    }

    @Test
    void utiliserNotEnoughQuantity() {
        Ingredient ingredient = new Laitier("Fromage", new UniteIngredientSolide());
        EntreeIngredientInventaire entree = new EntreeIngredientInventaire(ingredient, 1000);
        assertThrows(EntreeIngredientInventaireException.class, () -> { entree.utiliser(1200); });
    }

    @Test
    void ajouter() {
        Ingredient ingredient = new Laitier("Fromage", new UniteIngredientSolide());
        EntreeIngredientInventaire entree = new EntreeIngredientInventaire(ingredient, 1000);
        entree.ajouter(300);
        assertEquals(1300, entree.getQuantite());
    }
}