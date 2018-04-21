public class Monde {

    private Map[] tabMaps;
    private String currentSortie = "";
    private Map currentMap;

    public Monde() {

        tabMaps = new Map[200];
        tabMaps[0]= new Map ("Debut","Bienvenue dans ce super jeu !","bifurcation"," Voulez vous aller dans le chemin 1 ou 2 ?" ,"Gauche / Droite");
    }

    public Map[] getTabMaps() {
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
}