package plats;

import main.plats.PlatAuMenu;
import main.ingredients.*;
import main.plats.exceptions.PlatAuMenuException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatAuMenuTest {
    @Test
    void ingredientSuivantValid() {
        PlatAuMenu plat = new PlatAuMenu(1, "Mon plat", 8.99);
        Ingredient ingredient1 = new Viande("Cheval", new UniteIngredientSolide());
        Ingredient ingredient2 = new Viande("Boeuf", new UniteIngredientSolide());
        IngredientPlat ip1 = new IngredientPlat(ingredient1, 500);
        IngredientPlat ip2 = new IngredientPlat(ingredient2, 200);
        plat.ajouterIngredient(ip1);
        plat.ajouterIngredient(ip2);

        assertEquals(ip1, plat.getIngredientCourant());
        assertDoesNotThrow(plat::ingredientSuivant);
        assertEquals(ip2, plat.getIngredientCourant());
    }

    @Test
    void ingredientSuivantInvalid() {
        PlatAuMenu plat = new PlatAuMenu(1, "Mega plat", 999.99);
        assertThrows(PlatAuMenuException.class, plat::ingredientSuivant);
    }

    @Test
    void ingredientPrecedentValid() {
        PlatAuMenu plat = new PlatAuMenu(1, "Mon plat", 8.99);
        Ingredient ingredient1 = new Viande("Cheval", new UniteIngredientSolide());
        Ingredient ingredient2 = new Viande("Boeuf", new UniteIngredientSolide());
        IngredientPlat ip1 = new IngredientPlat(ingredient1, 500);
        IngredientPlat ip2 = new IngredientPlat(ingredient2, 200);
        plat.ajouterIngredient(ip1);
        plat.ajouterIngredient(ip2);

        assertEquals(ip1, plat.getIngredientCourant());
        assertDoesNotThrow(plat::ingredientSuivant);
        assertEquals(ip2, plat.getIngredientCourant());
        assertDoesNotThrow(plat::ingredientPrecedent);
        assertEquals(ip1, plat.getIngredientCourant());
    }

    @Test
    void ingredientPrecedentInvalid() {
        PlatAuMenu plat = new PlatAuMenu(12, "test", 123.99);
        assertThrows(PlatAuMenuException.class, plat::ingredientPrecedent);
    }
}