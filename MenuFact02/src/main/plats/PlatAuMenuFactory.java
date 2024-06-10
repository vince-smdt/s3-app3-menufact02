package main.plats;

public class PlatAuMenuFactory {
    public PlatAuMenu createPlatAuMenu(int code, String description, double prix) {
        return new PlatAuMenu(code, description, prix);
    }

    public PlatAuMenu createPlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        return new PlatSante(code, description, prix, kcal, chol, gras);
    }

    public PlatAuMenu createPlatEnfant(int code, String description, double prix, double proportion) {
        return new PlatEnfant(code, description, prix, proportion);
    }
}
