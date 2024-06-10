package Commandes;

import plats.PlatChoisi;

public class Commande {
    public EventManager events;
    public Chef chef;

    public Commande() {
        this.events = new EventManager("notification");
        this.chef = new Chef();
        this.events.subscribe("notification", this.chef);

    }

    public void setEtat(PlatChoisi plat, menufact.facture.Facture facture) {
        events.notify("notification", plat);
    }
}
