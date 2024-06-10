package facture;

public abstract class State {
    Facture facture;

    public State(Facture f){
        this.facture = f;
    }

    public abstract Boolean ajouterPlat();
    public abstract void ouvrir();
    public abstract void fermer();
    public abstract void payer();
    public abstract String print();
}
