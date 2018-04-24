import java.util.ArrayList;

public class Chapitre {

    private int numero;
    private ArrayList<Ennemi> listEnnemi= new ArrayList<>();


    public Chapitre (int _numero)
    {
        numero=_numero;
    }

    public void addEnnemi (Ennemi e)
    {
        listEnnemi.add(e);
    }
    public Ennemi getEnnemiChapitre() {
        return listEnnemi.get((int) (Math.random() *  listEnnemi.size()));
    }
}
