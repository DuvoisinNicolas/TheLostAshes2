import java.io.File;
import static java.lang.String.valueOf;


public class Map {

    public Map( Chapitre _chapitre , String _entree , String _texte , String _image , String _qcm , String _choix1,String _choix2, String _sortieChoix1,String _sortieChoix2, boolean _monstre)
    {
        chapitre=_chapitre;
        File f = new File ("");
        entree=_entree;
        texte=_texte;
        image= "file:///"+ f.getAbsolutePath() + "/files/" +  _image;
        qcm=_qcm;
        choix1=_choix1;
        choix2=_choix2;
        sortieChoix1=_sortieChoix1;
        sortieChoix2=_sortieChoix2;
        texte = setText(texte);
        ennemi= chapitre.getEnnemiChapitre();
        if (Main.getP().getAtk()>= ennemi.getAtk() && _monstre==true)
            texte+='\n'+ennemi.getVictoire();
        else if (Main.getP().getAtk()< ennemi.getAtk() && _monstre==true)
            texte+='\n'+ennemi.getDefaite();

    }

    private Ennemi ennemi;
    private Chapitre chapitre;
    private String entree;
    private String texte;
    private String image;
    private String qcm;
    private String choix1;
    private String choix2;
    private String sortieChoix1;
    private String sortieChoix2;
    private boolean visite=false;



    public String getEntree() {
        return entree;
    }

    public String getTexte() {
        return texte;
    }

    public String getChoix1() {
        return choix1;
    }

    public String getChoix2() {
        return choix2;
    }

    public String getImage() {
        return image;
    }

    public String getQcm() {
        return qcm;
    }

    public String getSortieChoix1() {
        return sortieChoix1;
    }

    public String getSortieChoix2() {
        return sortieChoix2;
    }

    public void setVisite(boolean visite) {
        this.visite = visite;
    }

    public static String setText (String texte)
    {
        char[] charArray= texte.toCharArray();
        int charCpt=0;
        int endlCpt=0;
        for (int i=0 ; i < charArray.length ; ++i)
        {
            ++charCpt;
            if (charCpt > 80 && charArray[i-1]=='.' && charArray[i]==' ')
            {
                charArray[i] = '\n';
                charCpt = 0;
                ++endlCpt;
                if (endlCpt>=4)
                    throw new ArrayIndexOutOfBoundsException("Trop de sauts de ligne");
            }

            if (charArray[i] == ' ' && charCpt >= 100)
            {
                charArray[i] = '\n';
                charCpt = 0;
                ++endlCpt;
                if (endlCpt>=5)
                    throw new ArrayIndexOutOfBoundsException("Trop de sauts de ligne");
            }
        }
        return valueOf(charArray);
    }

    public boolean getVisite ()
    {
        return this.visite;
    }
}