import javafx.beans.property.SimpleStringProperty;

public class Stats {
    private final SimpleStringProperty name;
    private final SimpleStringProperty guerrier;
    private final SimpleStringProperty archer;
    private final SimpleStringProperty pretre;
    private final SimpleStringProperty mage;

    public Stats(String _name, int _guerrier, int _archer, int _pretre, int _mage) {


        name = new SimpleStringProperty(_name);
        guerrier = new SimpleStringProperty(String.valueOf(_guerrier));
        archer = new SimpleStringProperty(String.valueOf(_archer));
        pretre = new SimpleStringProperty(String.valueOf(_pretre));
        mage = new SimpleStringProperty(String.valueOf(_mage));
    }

    public String getArcher() {
        return archer.get();
    }

    public String getGuerrier() {
        return guerrier.get();
    }

    public String getMage() {
        return mage.get();
    }

    public String getName() {
        return name.get();
    }

    public String getPretre() {
        return pretre.get();
    }
}
