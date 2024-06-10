package main.facture;

import main.Client.Client;
import main.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private State state;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;


    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        state = new EtatOuvert(this);
        courant = -1;
        this.description = description;
    }

    /**
     *
     * @param client le client de la facture
     */
    public void setClient (Client client)
    {
        this.client = client;
    }

    /**
     *
     * @return le client de la facture
     */
    public Client getClient ()
    {
        return this.client;
    }

    /**
     *
     * @return les plats choisis
     */
    public ArrayList<PlatChoisi> getPlatschoisi(){
        return platchoisi;
    }

    /**
     *
     * @return la valeur du TPS
     */
    public double getTPS(){
        return TPS;
    }

    /**
     *
     * @return la valeur du TVQ
     */
    public double getTVQ(){
        return TVQ;
    }

    /**
     *
     * @return l'état de la facture
     */
    public State getEtat()
    {
        return state;
    }

    /**
     *
     * @return l'état de la facture
     */
    public void setEtat(State state)
    {
        this.state = state;
    }

    /**
     *
     * @return la date de la facture
     */
    public Date getDate()
    {
        return date;
    }

    /**
     *
     * @return retourne la description de la facture
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Itérateur pour changer au plat suivant
     */
    public void platChoisiSuivant(){
        if(courant < platchoisi.size() - 1)
            courant++;
    }

    /**
     * Itérateur pour changer au plat précédant
     */
    public void platChoisiPrecedant(){
        if(courant > 0)
            courant--;
    }

    /**
     *
     * @return la plat que l'itérateur pointe
     */
    public PlatChoisi platChoisiCourant(){
        return platchoisi.get(courant);
    }

    /**
     *
     * @param p un plat choisi
     */
    public void ajouterPlat(PlatChoisi p)
    {
        platchoisi.add(p);
        courant = platchoisi.size() - 1;
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + getEtat().toString() +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }
}
