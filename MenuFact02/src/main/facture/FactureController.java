package main.facture;

import main.Chef.Chef;
import main.Client.Client;
import main.facture.exceptions.FactureException;
import main.plats.PlatChoisi;

import java.util.ArrayList;

public class FactureController {
    private Facture model;
    private FactureView view;
    ArrayList<Chef> listeners;

    public FactureController(String desc) {
        model = new Facture(desc);
        view = new FactureView();
        this.listeners = new ArrayList<>();
    }

    public void subscribe(Chef listener) {
        this.listeners.add(listener);
    }

    public void unsubscribe(Chef listener) {
        this.listeners.remove(listener);
    }

    public void notify(PlatChoisi plat) {
        for (Chef listener : this.listeners) {
            listener.update(plat);
        }
    }

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client) throws FactureException
    {
        model.setClient(client);
    }
    public Client getClient() {return model.getClient();}

    public ArrayList<PlatChoisi> getListePlat() { return model.getPlatschoisi(); }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
        for (PlatChoisi p : model.getPlatschoisi())
            soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return model.getTPS()*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return model.getTVQ()*(model.getTPS()+1)*sousTotal();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        model.getEtat().ouvrir();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer() throws FactureException
    {
        model.getEtat().payer();
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer() throws FactureException
    {
        model.getEtat().fermer();
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        if (model.getEtat().ajouterPlat()){
            notify(p);
            model.ajouterPlat(p);
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                "Date:" + model.getDate() + "\n" +
                "Description: " + model.getDescription() + "\n" +
                "Client.Client:" + model.getClient().getNom() + "\n" +
                "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : model.getPlatschoisi())
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }

    public String getEtat(){
        String s;

        s = model.getEtat().print();

        return view.viewEtat(s);
    }

    @Override
    public String toString() {
        return model.toString();
    }
}
