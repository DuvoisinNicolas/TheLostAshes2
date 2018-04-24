import java.util.ArrayList;

public class Chapitre {

    private int numero;
    private Ennemi ennemiChapitre;

    public Chapitre (int _numero , Ennemi e)
    {
        numero=_numero;
        ennemiChapitre = e;
    }

    public Ennemi getEnnemiChapitre() {
        return ennemiChapitre;
    }
}
