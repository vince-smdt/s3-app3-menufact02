package facture;

import main.facture.FactureController;
import main.facture.exceptions.FactureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Client.Client;
import main.plats.PlatAuMenu;
import main.plats.PlatChoisi;

import static org.junit.jupiter.api.Assertions.*;

class FactureControllerTest {
    FactureController controller;

    @BeforeEach
    void init(){
        controller = new FactureController("Facture test");

        PlatAuMenu platMenu1 = new PlatAuMenu(1, "Tarte", 9.99);
        PlatAuMenu platMenu2 = new PlatAuMenu(2, "Beigne", 7.99);
        PlatAuMenu platMenu3 = new PlatAuMenu(3, "Gateau", 11.99);

        PlatChoisi platChoisi = new PlatChoisi(platMenu1, 2);

        try {
            controller.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void associerClient() {
        try {
            Client c = new Client(1, "Testeur", "1111 1111 1111 1111");
            controller.associerClient(c);

            Client clientAssocier = controller.getClient();
            assertEquals(c.getIdClient(), clientAssocier.getIdClient());
            assertArrayEquals(c.getNom().toCharArray(), clientAssocier.getNom().toCharArray());
            assertArrayEquals(c.getNumeroCarteCredit().toCharArray(), clientAssocier.getNumeroCarteCredit().toCharArray());
        }catch (FactureException e){
            fail("Erreur lors de l'association d'un client");
        }
    }

    @Test
    void sousTotal() {
    }

    @Test
    void total() {
    }

    @Test
    void ouvrir() {
    }

    @Test
    void payer() {
    }

    @Test
    void fermer() {
    }

    @Test
    void ajoutePlat() {
    }

    @Test
    void genererFacture() {
    }
}