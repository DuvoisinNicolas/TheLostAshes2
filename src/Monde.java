import java.util.ArrayList;

public class Monde {

    private ArrayList<Map> tabMaps = new ArrayList<>();
    private ArrayList<Map> tabEnnemi = new ArrayList<>();
    private String currentSortie ;
    private Map currentMap;
    private Chapitre currentChapitre;

    public Monde() {

        Ennemi e1 = new Ennemi("Jeremie",12,"Vous avez compris l'UML , bravo ! Jérémie retourne se cacher","L'UML à eu raison de vous , vous perdez le combat et une vie");
        Chapitre chapitre1 = new Chapitre(1,e1);
        currentChapitre = chapitre1;

        Map map1 = new Map (1,"Entree","Vous vous réveillez completement assommé , sans savoir d'où vous venez ... Vous appercevez deux chemins en vous relevant. Celui de gauche semble mener à une forêt , et celui de droite à des collines.","bifurcation.jpg"," Voulez vous aller dans le chemin 1 ou 2 ?" ,"Gauche","Droite","Foret","Montagne",false,e1);
        tabMaps.add(map1);
        Map map2 = new Map(1,"Foret","Vous décidez d'entrer dans la forêt . Soudainement , vous entendez des cris de douleur.","foret.jpg","Que voulez vous faire ?","Aller aider !","Se cacher dans un buisson","ForetCri","Buisson",false,e1);
        tabMaps.add(map2);
        Map map3 = new Map(1,"Buisson","Vous vous cachez dans le buisson comme un lache . Les cris de douleur se font toujours entendre.","buisson.jpg","Voulez-vous attendre encore ?","Aller aider","Rester cacher ...","ForetCri","Buisson",false,e1);
        tabMaps.add(map3);
        Map map4 = new Map (1,"Montagne","Vous appercevez un homme caché dans les buissons. Vous décidez de l'interpeller. Il se dit se nommer Jérémie , maître du diagramme de classe. Il peut vous apprendre la maitrise de l'UML pour seulement 10 po.","jeremie.jpg","Acceptez-vous son offre ?","Accepter","Fuir","Montagne2","Entree",false,e1);
        tabMaps.add(map4);
        Map map5 = new Map (1,"Montagne2","Vous cherchez votre argent mais vous n'en avez pas","jeremie.jpg", "Que voulez-vous faire ?","Continuer d'avancer","Rester ici en PLS","Montagne 2","Montagne",true,e1);
        tabMaps.add(map5);






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

    public Chapitre getCurrentChapitre() {
        return currentChapitre;
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