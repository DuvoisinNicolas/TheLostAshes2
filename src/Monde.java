import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Monde {

    private ArrayList<File> tabMapsPaths = new ArrayList<>();
    private ArrayList<File> tabEnnemiPaths = new ArrayList<>();
    private ArrayList<Map> tabMaps = new ArrayList<>();
    private ArrayList<Chapitre> tabChapitre = new ArrayList<>();
    private String currentSortie;
    private Map currentMap;
    private Chapitre currentChapitre;


    public Monde() throws IOException {



        buildChapitre();

        Ennemi e1 = new Ennemi(1,"Jeremie",12,"Vous avez compris l'UML , bravo ! Jérémie retourne se cacher","L'UML à eu raison de vous , vous perdez le combat et une vie");
        Ennemi e2 = new Ennemi(1,"Jeremie",12,"Jérémie retourne se cacher","L'UML à eu raison de vous , vous perdez le combat et une vie");


        currentChapitre = tabChapitre.get(0);
        currentChapitre.addEnnemi(e1);
        currentChapitre.addEnnemi(e2);
    }

    public void buildWorld () throws IOException {
        //Récupere tout les fichiers .txt

        File f = new File ("");
        File file = new File("//"+ f.getAbsolutePath() + "/files/maps/");
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

    public void buildChapitre ()
    {
        ArrayList<String> chapNumbers = new ArrayList<>();
        for (int i=0;i<10;++i) {
            chapNumbers.add(String.valueOf(i));
            getTabChapitre().add(new Chapitre(chapNumbers.get(i)));
        }
    }

    public void buildEnnemi() throws IOException {

        File f = new File ("");
        File file = new File("//"+ f.getAbsolutePath() + "/files/ennemis/");
        File[] files = file.listFiles();

        if (files == null)
        {
            return;
        }
        for(File fichier: files)
        {
            if (fichier.getName().endsWith(".txt"))
            {
                tabEnnemiPaths.add(fichier);
            }
        }


        //Ajout des maps


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

            tabChapitre.get(valueOf(arguments.get(0))).getListEnnemi().add(new Ennemi (valueOf(arguments.get(0)),arguments.get(1),valueOf(arguments.get(2)),arguments.get(3),arguments.get(4)));
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
        this.currentChapitre = currentMap.getChapitre();
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