package main.facture;

/**
 * <p>Classe représentant l'état d'une facture payée. Elle hérite de la classe State qui lui donne toutes les fonctions a override</p>
 */
public class EtatPayer extends State{
    /**
     * <p>Constructeur qui permet d'envoyer la facture au parent (State)</p>
     * @param facture état de la facture lors du changement d'état. Utile pour le constructeur du parent
     */
    public EtatPayer(Facture facture){
        super(facture);
    }

    /**
     * <p>Override de la fonction pour ajouter un plat. Puisque la facture est payée, on ne peut pas ajouter de plats</p>
     * @return faux puisque la facture est payée
     */
    @Override
    public Boolean ajouterPlat() {
        return false;
    }

    /**
     * <p>Override de la fonction ouvrir, puisque la facture est payé on ne peut pas changer l'état a ouvrir</p>
     */
    @Override
    public void ouvrir(){

    }

    /**
     * <p>Override de la fonction fermer, puisque la facture est payé on ne peut pas changer l'état a fermé</p>
     */
    @Override
    public void fermer() {

    }

    /**
     * <p>Override de la fonction payer, qui permet de changer l'état de la facture a payé</p>
     */
    @Override
    public void payer() {
        facture.setEtat(new EtatPayer(facture));
    }

    /**
     * <p>Override de la fonction print, qui permet d'afficher l'état présent</p>
     */
    @Override
    public String print() {
        return "facture payee";
    }
}
