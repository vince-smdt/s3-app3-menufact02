package facture;

public class EtatOuvert extends State{
    public EtatOuvert(Facture facture){
        super(facture);
    }

    @Override
    public Boolean ajouterPlat() {
        return true;
    }

    @Override
    public void ouvrir(){
        facture.setEtat(new EtatOuvert(facture));
    }

    @Override
    public void fermer() {
        facture.setEtat(new EtatFermer(facture));
    }

    @Override
    public void payer() {
        facture.setEtat(new EtatPayer(facture));
    }

    @Override
    public String print() {
        return "facture ouverte";
    }
}
