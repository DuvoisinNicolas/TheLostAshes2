import java.util.ArrayList;

public class Chapitre {

    private String numero;
    private ArrayList<Ennemi> listEnnemi= new ArrayList<>();


    public Chapitre (String _numero)
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

    public String getNumero() {
        return numero;
    }

    public ArrayList<Ennemi> getListEnnemi() {
        return listEnnemi;
    }
}
