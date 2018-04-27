public class Ennemi {

    private int atk;
    private String nom;
    private String victoire;
    private String defaite;


    public Ennemi ( String _nom, int _atk,String _victoire,String _defaite)
    {
        atk=_atk;
        nom=_nom;
        victoire=_victoire;
        defaite=_defaite;

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
