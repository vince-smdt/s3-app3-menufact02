package facture;

import main.facture.EtatOuvert;
import main.facture.Facture;
import main.facture.FactureController;
import main.facture.exceptions.FactureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Client.Client;
import main.plats.PlatAuMenu;
import main.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FactureControllerTest {
    FactureController controller;

    @BeforeEach
    void init(){
        controller = new FactureController("Facture test");

        PlatAuMenu platMenu1 = new PlatAuMenu(1, "Tarte", 9.99);

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
        //2 * 9.99
        assertEquals(19.98, controller.sousTotal());

        PlatAuMenu platMenu = new PlatAuMenu(2, "Tarte", 9.99);
        PlatChoisi platChoisi = new PlatChoisi(platMenu, 1);
        try {
            controller.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        //3 * 9.99
        assertEquals(29.97, controller.sousTotal());
    }

    @Test
    void total() {
        //(2 * 9.99) + (0.05 * (2 * 9.99)) + (0.095 * (0.05 + 1) * (2 * 9.99))
        assertEquals(22.972005, controller.total());

        PlatAuMenu platMenu = new PlatAuMenu(2, "Tarte", 9.99);
        PlatChoisi platChoisi = new PlatChoisi(platMenu, 1);
        try {
            controller.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        //(3 * 9.99) + (0.05 * (3 * 9.99)) + (0.095 * (0.05 + 1) * (3 * 9.99))
        assertEquals(34.4580075, controller.total());
    }

    @Test
    void ouvrir() {
        try {
            controller.ouvrir();
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals("facture ouverte", controller.getEtat());

        try {
            controller.ouvrir();
            controller.fermer();
            controller.ouvrir();
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals("facture ouverte", controller.getEtat());
    }

    @Test
    void payer() {
        try {
            controller.payer();
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals("facture payee", controller.getEtat());

        try {
            controller.ouvrir();
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals("facture payee", controller.getEtat());
    }

    @Test
    void fermer() {
        try {
            controller.fermer();
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals("facture fermee", controller.getEtat());

        try {
            controller.ouvrir();
            controller.fermer();
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        assertEquals("facture fermee", controller.getEtat());
    }

    @Test
    void ajoutePlat() {
        ArrayList<PlatChoisi> liste = controller.getListePlat();

        assertEquals(1, liste.size());

        PlatAuMenu platMenu1 = new PlatAuMenu(1, "Tarte", 9.99);
        PlatChoisi platChoisi = new PlatChoisi(platMenu1, 2);

        try {
            controller.ajoutePlat(platChoisi);
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        liste = controller.getListePlat();
        assertEquals(2, liste.size());
    }

    @Test
    void genererFacture() {
        Client c = new Client(1, "Testeur", "1111 1111 1111 1111");
        try {
            controller.associerClient(c);
        } catch (FactureException e) {
            throw new RuntimeException(e);
        }

        Date date = new Date();

        assertEquals("Facture generee.\n" +
                "Date:" + date  + "\n" +
                "Description: Facture test\n" +
                "Client.Client:Testeur\n" +
                "Les plats commandes:\n" +
                "Seq   Plat         Prix   Quantite\n" +
                "1     Tarte  9.99      2\n" +
                "          TPS:               0.9990000000000001\n" +
                "          TVQ:               1.9930050000000001\n" +
                "          Le total est de:   22.972005\n", controller.genererFacture());
    }
}