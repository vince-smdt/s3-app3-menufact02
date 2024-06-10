package main.Chef;

import main.Chef.exceptions.ChefException;
import main.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * <p>Classe représentant un cuisinier</p>
 */
public class Chef {
    ArrayList<PlatChoisi> commandes;

    /**
     * <p>Constructeur de la classe</p>
     */
    public Chef() {
        commandes = new ArrayList<>();
    }

    /**
     * <p>Méthode pour mettre a jour l'état d'un plat par un chef</p>
     * @param iPlat L'index du plat a modifier
     * @param etat Enumération des états (0=Commande, 1=En_preparation, 2=Termine, 3=Servi, 4=Impossible_de_servir)
     * @throws ChefException classe de gestion des exceptions de la classe Chef
     */
    public void changerEtatPlat(int iPlat, int etat) throws ChefException {
        ArrayList<PlatChoisi> nouveau = new ArrayList<>();
        for (int i = 0; i < commandes.size(); i++){
            PlatChoisi p = commandes.get(i);
            if(iPlat == i)
                p.setEtat(etat);
            nouveau.add(p);
        }

        commandes = nouveau;
    }

    /**
     * <p>Méthode appelé par l'observateur lorsqu'il est déclanché. ELle ajoute le plat dans les commandes du chef</p>
     * @param plat plat ajouté dans la facture
     */
    public void update(PlatChoisi plat) {
        commandes.add(plat);
        System.out.println("Plat a preparer: " + plat.toString());
    }

    /**
     * <p>Méthode pour retourner la liste des plats du chefs<p/>
     * @return liste des plats
     */
    public ArrayList<PlatChoisi> getList(){ return commandes; }
}
