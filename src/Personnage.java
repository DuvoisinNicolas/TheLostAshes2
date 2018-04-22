public class Personnage {

    public Personnage()
    {
        name="";
        atk=3;
        def=0;
        hp=5;
    }

    private String name;
    private int atk;
    private int def;
    private int hp;

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}