package main.Client;

/**
 * <p>Classe représentant un client du restaurent.</p>
 */
public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * <p>Constructeur de la classe</p>
     * @param idClient Identifiant représentant le client
     * @param nom Nom du client
     * @param numeroCarteCredit Numéro de carte du client
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * <p>Retourne l'identifiant</p>
     * @return Entier représentant l'identifiant du client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * <p>Permet de modifier l'identifiant</p>
     * @param idClient nouveau identifiant
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * <p>Retourne le nom du client</p>
     * @return String contenant le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * <p>Permet de modifier le nom du Client</p>
     * @param nom String contenant le nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * <p>Retourne le numéro de carte</p>
     * @return String contenant le numéro de carte
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     * <p>Permet de modifier le numéro de carte</p>
     * @param numeroCarteCredit String contenant le nouveau numéro de carte
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * <p>Override de la fonction toString pour permettre d'afficher les informations du client</p>
     * @return Le client sous forme de texte
     */
    @Override
    public String toString() {
        return "menufact.Client.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client.Client{}
* */