package main.facture;

/**
 * <p>Classe représentant l'état d'une facture ouverte. Elle hérite de la classe State qui lui donne toutes les fonctions a override</p>
 */
public class EtatOuvert extends State{
    /**
     * <p>Constructeur qui permet d'envoyer la facture au parent (State)</p>
     * @param facture état de la facture lors du changement d'état. Utile pour le constructeur du parent
     */
    public EtatOuvert(Facture facture){
        super(facture);
    }

    /**
     * <p>Override de la fonction pour ajouter un plat. Puisque la facture est ouverte, on peut ajouter des plats</p>
     * @return vrai puisque la facture est ouverte
     */
    @Override
    public Boolean ajouterPlat() {
        return true;
    }

    /**
     * <p>Override de la fonction ouvrir, qui permet de changer l'état de la facture a ouvert</p>
     */
    @Override
    public void ouvrir(){
        facture.setEtat(new EtatOuvert(facture));
    }

    /**
     * <p>Override de la fonction fermer, qui permet de changer l'état de la facture a fermé</p>
     */
    @Override
    public void fermer() {
        facture.setEtat(new EtatFermer(facture));
    }

    /**
     * <p>Override de la fonction payer, qui permet de changer l'état de la facture a payer</p>
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
        return "facture ouverte";
    }
}
