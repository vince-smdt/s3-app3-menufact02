package main.Menu;

import main.exceptions.MenuException;
import main.plats.PlatAuMenu;

import java.util.ArrayList;

/**
 * <p>Menu contenant des plats pouvant etre commandes</p>
 */
public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();

    /**
     * <p>Constructeur</p>
     * @param description Description du menu
     */
    public Menu(String description) {
        this.description = description;
    }

    /**
     * <p>Ajoute un plat au menu</p>
     * @param p Plat a ajouter au menu
     */
    public void ajoute(PlatAuMenu p)
    {
        plat.add(p);
    }

    /**
     * <p>Choisir la position du plat courant dans le menu</p>
     * @param i Position de l'index du plat courant
     */
    public void position(int i)
    {
        courant = i;
    }

    /**
     * <p>Retourne le plat courant du menu, selectionne par l'index</p>
     * @return Le plat courant
     */
    public PlatAuMenu platCourant()
    {
        return plat.get(courant);
    }

    /**
     * <p>Selectionne le plat suivant dans le menu</p>
     * @throws MenuException Si l'index depasse le nombre maximal de plats
     */
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * <p>Selectionne le plat precedent dans le menu</p>
     * @throws MenuException Si l'index depasse le nombre minimal de plats
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /**
     * <p>Retourne les informations du menu sous forme de String</p>
     * @return La String representant le menu
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
