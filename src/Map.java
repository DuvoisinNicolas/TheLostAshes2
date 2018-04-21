import java.util.*;

public class Map {

    public Map( String _entree , String _texte , String _image , String _qcm , String _choix)
    {
        entree=_entree;
        texte=_texte;
        image="TheLostAshes2/files/" + _image;
        qcm=_qcm;
        choix=_choix;
    }

    private string entree;
    private string sortie;
    private string texte;
    private string image;
    private string qcm;
    private string choix;

    void setSortie ();

}