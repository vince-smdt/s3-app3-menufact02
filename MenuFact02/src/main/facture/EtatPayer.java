package main.facture;

public class EtatPayer extends State{
    public EtatPayer(Facture facture){
        super(facture);
    }

    @Override
    public Boolean ajouterPlat() {
        return false;
    }

    @Override
    public void ouvrir(){

    }

    @Override
    public void fermer() {

    }

    @Override
    public void payer() {
        facture.setEtat(new EtatPayer(facture));
    }

    @Override
    public String print() {
        return "facture payee";
    }
}
