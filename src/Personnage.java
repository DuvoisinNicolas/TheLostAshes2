public class Personnage {

    public Personnage()
    {
        name="";
        atk=0;
        hp=0;
        magie=0;
        foi=0;
        charisme=0;
    }

    private String name;
    private int atk;
    private int hp;
    private int magie;
    private int foi;
    private int charisme;

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getStat (String stat)
    {
        switch (stat)
        {
            case "foi":
                return foi;
            case "magie":
                return magie;
            case "charisme":
                return charisme;
            default:
                return 0;
        }

    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setCharisme(int charisme) {
        this.charisme = charisme;
    }

    public void setFoi(int foi) {
        this.foi = foi;
    }

    public void setMagie(int magie) {
        this.magie = magie;
    }
}