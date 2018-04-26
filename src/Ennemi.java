public class Ennemi {

    private int atk;
    private String nom;
    private String victoire;
    private String defaite;
    private int chapitre;

    public Ennemi (int _chapitre , String _nom, int _atk,String _victoire,String _defaite)
    {
        atk=_atk;
        nom=_nom;
        victoire=_victoire;
        defaite=_defaite;
        chapitre=_chapitre;

    }

    public int getChapitre() {
        return chapitre;
    }

    public int getAtk() {
        return atk;
    }

    public String getDefaite() {
        return defaite;
    }

    public String getNom() {
        return nom;
    }

    public String getVictoire() {
        return victoire;
    }
}
