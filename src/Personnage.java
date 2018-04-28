public class Personnage {

    public Personnage()
    {
        name="";
        atk=3;
        hp=5;
        foi=100;
    }

    private String name;
    private int atk;
    private int hp;
    private int foi;

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
        if (stat.equals("foi"))
            return foi;
        else return 0;
    }
}