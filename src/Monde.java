import java.io.*;
import java.util.ArrayList;

public class Monde {

    private ArrayList<File> tabMapsPaths = new ArrayList<>();
    private ArrayList<Map> tabMaps = new ArrayList<>();
    private ArrayList<Map> tabEnnemi = new ArrayList<>();
    private String currentSortie;
    private Map currentMap;
    private Chapitre currentChapitre;


    public Monde() throws IOException {


        //Récupere tout les fichiers .txt

        File f = new File ("");
        File file = new File("//"+ f.getAbsolutePath() + "/files/");
        File[] files = file.listFiles();

        if (files == null)
        {
            return;
        }
        for(File fichier: files)
        {
            if (fichier.getName().endsWith(".txt"))
            {
                tabMapsPaths.add(fichier);
            }
        }


        //Ajout des maps

        Ennemi e1 = new Ennemi("Jeremie",12,"Vous avez compris l'UML , bravo ! Jérémie retourne se cacher","L'UML à eu raison de vous , vous perdez le combat et une vie");
        Chapitre chapitre1 = new Chapitre(1);
        currentChapitre = chapitre1;
        currentChapitre.addEnnemi(e1);

        for (File fic : tabMapsPaths)
        {

            BufferedReader br = new BufferedReader(new FileReader(fic));
            String line = br.readLine();
            while (line != null)
            {
                line=br.readLine();
            }

            tabMaps.add(new Map (param1,param2,param3,...));

        }
        Map map1 = new Map (chapitre1,"Entree","Vous vous réveillez completement assommé , sans savoir d'où vous venez ... Vous appercevez deux chemins en vous relevant. Celui de gauche semble mener à une forêt , et celui de droite à des collines.","bifurcation.jpg"," Voulez vous aller dans le chemin 1 ou 2 ?" ,"Gauche","Droite","Foret","Montagne",false);
        tabMaps.add(map1);
        Map map2 = new Map(chapitre1,"Foret","Vous décidez d'entrer dans la forêt . Soudainement , vous entendez des cris de douleur.","foret.jpg","Que voulez vous faire ?","Aller aider !","Se cacher dans un buisson","ForetCri","Buisson",false);
        tabMaps.add(map2);
        Map map3 = new Map(chapitre1,"Buisson","Vous vous cachez dans le buisson comme un lache . Les cris de douleur se font toujours entendre.","buisson.jpg","Voulez-vous attendre encore ?","Aller aider","Rester cacher ...","ForetCri","Buisson",false);
        tabMaps.add(map3);
        Map map4 = new Map (chapitre1,"Montagne","Vous appercevez un homme caché dans les buissons. Vous décidez de l'interpeller. Il se dit se nommer Jérémie , maître du diagramme de classe. Il peut vous apprendre la maitrise de l'UML pour seulement 10 po.","jeremie.jpg","Acceptez-vous son offre ?","Accepter","Fuir","Montagne2","Entree",false);
        tabMaps.add(map4);
        Map map5 = new Map (chapitre1,"Montagne2","Vous cherchez votre argent mais vous n'en avez pas. Jérémie vous attaque donc avec une force de 12 !","jeremie.jpg", "Que voulez-vous faire ?","Continuer d'avancer","Rester ici en PLS","Montagne 2","Montagne",true);
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