package main.facture;

/**
 * <p>Fonction State pour représenter tous les états de la facture</p>
 */
public abstract class State {
    Facture facture;

    public State(Facture f){
        this.facture = f;
    }

    /**
     *
     * @return un Bool qui défini si on peut ajouter une repas a la facture
     */
    public abstract Boolean ajouterPlat();

    /**
     * Change l'état a ouvert
     */
    public abstract void ouvrir();
    /**
     * Change l'état a fermer
     */
    public abstract void fermer();
    /**
     * Change l'état a payer
     */
    public abstract void payer();

    /**
     *
     * @return l'état en suite de charactère
     */
    public abstract String print();
}
