package main.Chef;

import main.Chef.exceptions.ChefException;
import main.plats.PlatChoisi;

import java.util.ArrayList;

public class Chef {
    ArrayList<PlatChoisi> commandes;

    public Chef() {

    }

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

    public void update(PlatChoisi plat) {
        commandes.add(plat);
        System.out.println("Plat a preparer: " + plat.toString());
    }
}
