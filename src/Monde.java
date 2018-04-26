import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Monde {

    private ArrayList<File> tabMapsPaths = new ArrayList<>();
    private ArrayList<File> tabEnnemiPaths = new ArrayList<>();
    private ArrayList<Ennemi> tabEnnemi= new ArrayList();
    private ArrayList<Map> tabMaps = new ArrayList<>();
    private String currentSortie;
    private Map currentMap;


    public Monde() throws IOException {

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
            tabMaps.add(new Map (arguments.get(0),arguments.get(1),arguments.get(2),arguments.get(3),arguments.get(4),arguments.get(5),arguments.get(6),arguments.get(7)));

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


        int i=0;
        for (File fic : tabEnnemiPaths)
        {

            ArrayList<String> arguments = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(fic));
            String line = br.readLine();
            while (line != null)
            {
                arguments.add(line);
                line=br.readLine();
            }
            tabEnnemi.add(new Ennemi (arguments.get(0),valueOf(arguments.get(1)),arguments.get(2),arguments.get(3)));
            System.out.println(tabEnnemi.get(i).getNom());
            ++i;
        }
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

    public ArrayList<Ennemi> getTabEnnemi() {
        return tabEnnemi;
    }
}