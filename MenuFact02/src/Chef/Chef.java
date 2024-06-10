package Chef;

import plats.PlatChoisi;

import java.util.ArrayList;

public class Chef {
    ArrayList<PlatChoisi> commandes;

    public Chef() {

    }

    public void update(PlatChoisi plat) {
        commandes.add(plat);
        System.out.println("Plat a preparer: " + plat.toString());
    }
}
