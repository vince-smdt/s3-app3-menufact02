package main.plats;

/**
 * <p>Plat au menu format sante</p>
 */
public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    /**
     * <p>Constructeur</p>
     * @param code Code du plat
     * @param description Description du plat
     * @param prix Prix du plat
     * @param kcal Calories du plat
     * @param chol Cholesterol du plat
     * @param gras Gras du plat
     */
    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        super(code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * <p>Retourne la String contenant les informations du plat sante</p>
     * @return Les informations du plat sante
     */
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    /**
     * <p>Retourne le nombre de calories du plat sante</p>
     * @return Le nombre de calories
     */
    public double getKcal() {
        return kcal;
    }

    /**
     * <p>Retourne le cholesterol du plat sante</p>
     * @return Le cholesterol du plat
     */
    public double getChol() {
        return chol;
    }

    /**
     * <p>Retourne le montant de gras du plat</p>
     * @return Le montant de gras du plat
     */
    public double getGras() {
        return gras;
    }
}
