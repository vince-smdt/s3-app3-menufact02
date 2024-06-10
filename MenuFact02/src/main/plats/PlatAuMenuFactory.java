package main.plats;

public class PlatAuMenuFactory {
    PlatAuMenu createPlatAuMenu(int code, String description, double prix) {
        return new PlatAuMenu(code, description, prix);
    }

    PlatAuMenu createPlatSante(int code, String description, double prix, double kcal, double chol, double gras) {
        return new PlatSante(code, description, prix, kcal, chol, gras);
    }

    PlatAuMenu createPlatEnfant(int code, String description, double prix, double proportion) {
        return new PlatEnfant(code, description, prix, proportion);
    }
}
