package plats;

import main.plats.PlatAuMenu;
import main.plats.PlatAuMenuFactory;
import main.plats.PlatEnfant;
import main.plats.PlatSante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatAuMenuFactoryTest {
    @Test
    void createPlatAuMenu() {
        PlatAuMenuFactory factory = new PlatAuMenuFactory();
        PlatAuMenu plat = factory.createPlatAuMenu(1, "Un plat", 13.99);

        assertEquals(1, plat.getCode());
        assertEquals("Un plat", plat.getDescription());
        assertEquals(13.99, plat.getPrix());
    }

    @Test
    void createPlatSante() {
        PlatAuMenuFactory factory = new PlatAuMenuFactory();
        PlatSante platSante = (PlatSante) factory.createPlatSante(5, "Un plat sante", 99.99, 1200, 20, 10);

        assertEquals(1200, platSante.getKcal());
        assertEquals(20, platSante.getChol());
        assertEquals(10, platSante.getGras());
    }

    @Test
    void createPlatEnfant() {
        PlatAuMenuFactory factory = new PlatAuMenuFactory();
        PlatEnfant platEnfant = (PlatEnfant) factory.createPlatEnfant(10, "Un plat enfant", 8.99, 0.5);

        assertEquals(0.5, platEnfant.getProportion());
    }
}