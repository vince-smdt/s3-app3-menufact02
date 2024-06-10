package ingredients;

import main.ingredients.*;
import main.ingredients.exceptions.IngredientInventaireException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientInventaireTest {
    @BeforeEach
    void viderInventaire() {
        IngredientInventaire.getInstance().viderInventaire();
    }

    @Test
    void getInstance() {
        IngredientInventaire instance1 = IngredientInventaire.getInstance();
        IngredientInventaire instance2 = IngredientInventaire.getInstance();
        assertNotNull(instance1);
        assertEquals(instance2, instance1);
    }

    @Test
    void entreeSuivanteValid() {
        Ingredient ingredient1 = new Viande("Steak", new UniteIngredientSolide());
        Ingredient ingredient2 = new Fruit("Fraise", new UniteIngredientSolide());
        EntreeIngredientInventaire entree1 = new EntreeIngredientInventaire(ingredient1, 10);
        EntreeIngredientInventaire entree2 = new EntreeIngredientInventaire(ingredient2, 200);

        IngredientInventaire.getInstance().ajouterEntree(entree1);
        IngredientInventaire.getInstance().ajouterEntree(entree2);

        EntreeIngredientInventaire entreeCourante1 = IngredientInventaire.getInstance().getEntreeCourante();
        assertDoesNotThrow(() -> { IngredientInventaire.getInstance().entreeSuivante(); });
        EntreeIngredientInventaire entreeCourante2 = IngredientInventaire.getInstance().getEntreeCourante();

        assertNotEquals(entreeCourante1, entreeCourante2);
        assertEquals(entree1, entreeCourante1);
        assertEquals(entree2, entreeCourante2);
    }

    @Test
    void entreeSuivanteInventaireVide() {
        assertThrows(IngredientInventaireException.class, () -> {
            IngredientInventaire.getInstance().entreeSuivante();
        });
    }

    @Test
    void entreeSuivanteInventaireUneEntree() {
        Ingredient ingredient = new Legume("Broccoli", new UniteIngredientSolide());
        EntreeIngredientInventaire entree = new EntreeIngredientInventaire(ingredient, 1234);
        IngredientInventaire.getInstance().ajouterEntree(entree);

        assertThrows(IngredientInventaireException.class, () -> {
            IngredientInventaire.getInstance().entreeSuivante();
        });
    }

    @Test
    void entreeSuivanteInventaireDeuxEntrees() {
        Ingredient ingredient1 = new Laitier("Lait", new UniteIngredientLiquide());
        Ingredient ingredient2 = new Epice("Sel", new UniteIngredientSolide());
        EntreeIngredientInventaire entree1 = new EntreeIngredientInventaire(ingredient1, 10000);
        EntreeIngredientInventaire entree2 = new EntreeIngredientInventaire(ingredient2, 20000);
        IngredientInventaire.getInstance().ajouterEntree(entree1);
        IngredientInventaire.getInstance().ajouterEntree(entree2);

        assertDoesNotThrow(() -> { IngredientInventaire.getInstance().entreeSuivante(); });
        assertThrows(IngredientInventaireException.class, () -> {
            IngredientInventaire.getInstance().entreeSuivante();
        });
    }

    @Test
    void entreePrecedenteValid() {
        Ingredient ingredient1 = new Viande("Steak", new UniteIngredientSolide());
        Ingredient ingredient2 = new Fruit("Fraise", new UniteIngredientSolide());
        EntreeIngredientInventaire entree1 = new EntreeIngredientInventaire(ingredient1, 10);
        EntreeIngredientInventaire entree2 = new EntreeIngredientInventaire(ingredient2, 200);

        IngredientInventaire.getInstance().ajouterEntree(entree1);
        IngredientInventaire.getInstance().ajouterEntree(entree2);

        EntreeIngredientInventaire entreeCourante1 = IngredientInventaire.getInstance().getEntreeCourante();
        assertEquals(entree1, entreeCourante1);
        assertDoesNotThrow(() -> { IngredientInventaire.getInstance().entreeSuivante(); });
        EntreeIngredientInventaire entreeCourante2 = IngredientInventaire.getInstance().getEntreeCourante();
        assertEquals(entree2, entreeCourante2);
        assertDoesNotThrow(() -> { IngredientInventaire.getInstance().entreePrecedente(); });
        EntreeIngredientInventaire entreeCourante3 = IngredientInventaire.getInstance().getEntreeCourante();
        assertEquals(entree1, entreeCourante3);
    }

    @Test
    void entreePrecedenteInventaireVide() {
        assertThrows(IngredientInventaireException.class, () -> {
            IngredientInventaire.getInstance().entreePrecedente();
        });
    }

    @Test
    void ajouterEntreeMemeIngredients() {
        Ingredient pareil1 = new Fruit("Framboise", new UniteIngredientSolide());
        Ingredient unique = new Legume("Artichaut", new UniteIngredientSolide());
        EntreeIngredientInventaire entreePareille1 = new EntreeIngredientInventaire(pareil1, 10000);
        EntreeIngredientInventaire entreeUnique = new EntreeIngredientInventaire(unique, 5000);
        IngredientInventaire.getInstance().ajouterEntree(entreePareille1);
        IngredientInventaire.getInstance().ajouterEntree(entreeUnique);

        assertEquals(10000, IngredientInventaire.getInstance().getEntreeCourante().getQuantite());

        Ingredient pareil2 = new Fruit("Framboise", new UniteIngredientSolide());
        EntreeIngredientInventaire entreePareille2 = new EntreeIngredientInventaire(pareil2, 2500);
        IngredientInventaire.getInstance().ajouterEntree(entreePareille2);

        assertEquals(2, IngredientInventaire.getInstance().getNombreEntrees());
        assertEquals(2500, IngredientInventaire.getInstance().getEntreeCourante().getQuantite());
    }
}