package main.facture;

/**
 * <p>Classe de vue pour les factures</p>
 */
public class FactureView {

    public FactureView(){
    }

    /**
     *
     * @param etat etat de la facture en suite de charactère
     * @return la vue de l'état de la facture
     */
    public String viewEtat(String etat){
        return etat;
    }
}
