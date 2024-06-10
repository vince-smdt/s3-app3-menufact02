package Commandes;

import plats.PlatChoisi;

public class Chef implements EventListener {

    public Chef() {

    }

    @Override
    public void update(String eventType, PlatChoisi plat) {
        System.out.println("Plat: " + plat.toString() + "a preparer.");
    }
}
