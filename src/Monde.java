import java.io.*;
import java.util.ArrayList;

public class Monde {

    private ArrayList<File> tabMapsPaths = new ArrayList<>();
    private ArrayList<Map> tabMaps = new ArrayList<>();
    private ArrayList<Chapitre> tabChapitre = new ArrayList<>();
    private String currentSortie;
    private Map currentMap;
    private Chapitre currentChapitre;


    public Monde() throws IOException {

        Ennemi e1 = new Ennemi("Jeremie",12,"Vous avez compris l'UML , bravo ! Jérémie retourne se cacher","L'UML à eu raison de vous , vous perdez le combat et une vie");
        Chapitre chapitre1 = new Chapitre(1);
        tabChapitre.add(chapitre1);
        currentChapitre = chapitre1;
        currentChapitre.addEnnemi(e1);;
    }

    public void buildWorld () throws IOException {
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


        int i = 0;
        for (File fic : tabMapsPaths)
        {

            ArrayList<String> arguments = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(fic));
            String line = br.readLine();
            while (line != null)
            {
                arguments.add(line);
                line=br.readLine();
            }

            tabMaps.add(new Map (arguments.get(0),arguments.get(1),arguments.get(2),arguments.get(3),arguments.get(4),arguments.get(5),arguments.get(6),arguments.get(7),arguments.get(8)));
            tabMaps.get(i).buildChapitre();
            ++i;
        }
    }

    public ArrayList<Chapitre> getTabChapitre() {
        return tabChapitre;
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