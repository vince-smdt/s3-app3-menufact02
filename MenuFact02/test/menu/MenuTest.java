package menu;

import main.Menu.Menu;
import main.exceptions.MenuException;
import main.plats.PlatAuMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @Test
    void position() {
        Menu menu = new Menu("Menu");
        PlatAuMenu plat1 = new PlatAuMenu(1, "Plat 1", 9.99);
        PlatAuMenu plat2 = new PlatAuMenu(1, "Plat 2", 19.99);
        menu.ajoute(plat1);
        menu.ajoute(plat2);

        assertEquals(plat1, menu.platCourant());
        menu.position(1);
        assertEquals(plat2, menu.platCourant());
    }

    @Test
    void positionSuivanteValid() {
        Menu menu = new Menu("Menu");
        PlatAuMenu plat1 = new PlatAuMenu(1, "Plat 1", 9.99);
        PlatAuMenu plat2 = new PlatAuMenu(1, "Plat 2", 19.99);
        menu.ajoute(plat1);
        menu.ajoute(plat2);

        assertEquals(plat1, menu.platCourant());
        assertDoesNotThrow(menu::positionSuivante);
        assertEquals(plat2, menu.platCourant());
    }

    @Test
    void positionSuivanteInvalid() {
        Menu menu = new Menu("My menu");
        assertThrows(MenuException.class, menu::positionSuivante);
    }

    @Test
    void positionPrecedenteValid() {
        Menu menu = new Menu("Menu");
        PlatAuMenu plat1 = new PlatAuMenu(1, "Plat 1", 9.99);
        PlatAuMenu plat2 = new PlatAuMenu(1, "Plat 2", 19.99);
        menu.ajoute(plat1);
        menu.ajoute(plat2);

        assertEquals(plat1, menu.platCourant());
        assertDoesNotThrow(menu::positionSuivante);
        assertEquals(plat2, menu.platCourant());
        assertDoesNotThrow(menu::positionPrecedente);
        assertEquals(plat1, menu.platCourant());
    }

    @Test
    void positionPrecedenteInvalid() {
        Menu menu = new Menu("Menu");
        assertThrows(MenuException.class, menu::positionPrecedente);
    }
}