import java.util.ArrayList;

public class Monde {

    private ArrayList<Map> tabMaps = new ArrayList<>();
    private String currentSortie ;
    private Map currentMap = new Map("","","","","","","","");

    public Monde() {
        Map map1 = new Map ("Entree","Vous vous réveillez completement assommé , sans savoir d'où vous venez ... Vous appercevez deux chemins en vous relevant. Celui de gauche semble mener à une forêt , et celui de droite à des collines.","bifurcation.jpg"," Voulez vous aller dans le chemin 1 ou 2 ?" ,"Gauche","Droite","Foret","Montagne");
        tabMaps.add(map1);
        Map map2 = new Map("Foret","Vous décidez d'entrer dans la forêt . Soudainement , vous entendez des cris de douleur.","foret.jpg","Que voulez vous faire ?","Aller aider !","Se cacher dans un buisson","ForetCri","Buisson");
        tabMaps.add(map2);
        Map map3 = new Map("Buisson","Vous vous cachez dans le buisson comme un lache . Les cris de douleur se font toujours entendre.","buisson.jpg","Voulez-vous attendre encore ?","Aller aider","Rester cacher ...","ForetCri","Buisson");
        tabMaps.add(map3);
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