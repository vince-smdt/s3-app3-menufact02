package main.plats;

/**
 * <p>Plat choisi par le client, stocke dans une facture</p>
 */
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private EtatPlat etat;

    /**
     * <p>Constructeur</p>
     * @param plat Plat choisi
     * @param quantite Nombre de plats commandes
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        this.etat = EtatPlat.Commande;
    }

    /**
     * <p>Retourne une String contenant les informations du plat choisi</p>
     * @return String contenant les informations du plat choisi
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    /**
     * <p>Retourne le nombre de plats commandes</p>
     * @return Quantite du plat
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * <p>Defini le nombre de plats commande</p>
     * @param quantite Le nombre de plats commande
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * <p>Retourne le plat choisi</p>
     * @return Le plat choisi
     */
    public PlatAuMenu getPlat() {
        return plat;
    }

    /**
     * <p>Defini l'etat du plat choisi</p>
     * @param e L'etat du plat choisi
     */
    public void setEtat(int e){
        this.etat = EtatPlat.values()[e];
    }
}
