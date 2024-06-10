package main.Chef;

import main.facture.Facture;
import main.facture.FactureController;
import main.facture.exceptions.FactureException;
import main.plats.PlatAuMenu;
import main.plats.PlatChoisi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {
    Chef chef;
    FactureController controller;

    @BeforeEach
    void init(){
        chef = new Chef();
        controller = new FactureController("Test");
    }

    @Test
    void update() {
        PlatAuMenu platMenu1 = new PlatAuMenu(1, "Tarte", 9.99);
        PlatChoisi platChoisi = new PlatChoisi(platMenu1, 1);

        try {
            controller.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, chef.getList().size());

        controller.subscribe(chef);

        try {
            controller.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals(1, chef.getList().size());
    }
}