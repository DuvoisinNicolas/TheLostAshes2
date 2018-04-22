import java.util.ArrayList;
import java.util.LinkedList;

public class Monde {

    private ArrayList<Map> tabMaps = new ArrayList<>();
    private String currentSortie = "";
    private Map currentMap = new Map("","","","","");
    private int currentIndice;

    public Monde() {
        Map map1 = new Map ("Debut","Bienvenue dans ce super jeu !","bifurcation.jpg"," Voulez vous aller dans le chemin 1 ou 2 ?" ,"Gauche / Droite");
        tabMaps.add(map1);
    }

    public ArrayList<Map> getTabMaps() {
        return tabMaps;
    }

    public void setCurrentSortie(String currentSortie) {
        this.currentSortie = currentSortie;
    }

    public String getCurrentSortie() {
        return currentSortie;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public int getCurrentIndice()
    {
        for (int i=0 ; i<tabMaps.size(); ++i)
        {
            if (tabMaps.get(i)==currentMap)
            {
                return i;
            }
        }
        return 0;

    }
}