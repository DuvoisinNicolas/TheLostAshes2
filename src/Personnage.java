public class Personnage {

    public Personnage()
    {
        name="";
        atk=3;
        hp=5;
    }

    private String name;
    private int atk;
    private int hp;

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public int getHp() {
        return hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
}