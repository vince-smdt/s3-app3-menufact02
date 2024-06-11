package main.plats;

/**
 * <p>Plat au menu format enfant, avec proportion reduite</p>
 */
public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    /**
     * <p>Constructeur</p>
     * @param code Code du plat
     * @param description Description du plat
     * @param prix Prix du plat
     * @param proportion Proportion reduite du plat pour le format enfant
     */
    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }

    /**
     * <p>Retourne la proportion du plat enfant</p>
     * @return La proportion reduite du plat
     */
    public double getProportion() {
        return proportion;
    }

    /**
     * <p>Retourne une String contenant les informations du plat enfant</p>
     * @return String contenant les informations du plat enfant
     */
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
