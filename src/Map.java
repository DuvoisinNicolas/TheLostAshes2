import static java.lang.String.valueOf;


public class Map {

    public Map(String _entree , String _texte , String _qcm , String _choix1,String _choix2, String _sortieChoix1,String _sortieChoix2, String _monstre, String _stat , String _victoire , String _defaite)
    {

        entree=_entree;
        texte=_texte;
        qcm=_qcm;
        choix1=_choix1;
        choix2=_choix2;
        sortieChoix1=_sortieChoix1;
        sortieChoix2=_sortieChoix2;
        texte = setText(texte);
        monstreTemp=_monstre;
        stat=_stat;
        victoire=_victoire;
        defaite=_defaite;


    }
    private String stat;
    private Ennemi ennemiParDefaut = new Ennemi("AucunMonstre",0,"Erreur","Erreur");
    private String monstreTemp;
    private Ennemi ennemi;
    private String entree;
    private String texte;
    private String qcm;
    private String choix1;
    private String choix2;
    private String sortieChoix1;
    private String sortieChoix2;
    private String victoire;
    private String defaite;

    public void checkVictoireDefaite()
    {
        if (victoire.equals("Victoire"))
            Main.getM().setVictoire(true);
        if (defaite.equals("Defaite"))
            Main.getM().setDefaite(true);
    }

    public void trouverMonstre ()
    {
        for (int i = 0 ; i<Main.getM().getTabEnnemi().size() ; ++i)
        {
            if (!monstreTemp.equals("AucunMonstre") && Main.getM().getTabEnnemi().get(i).getNom().equals(monstreTemp))
                ennemi = Main.getM().getTabEnnemi().get(i);
        }

        if(monstreTemp.equals("AucunMonstre"))
        {
            ennemi=ennemiParDefaut;
        }

    }
    public void calculerResultatCombat()
    {
        if (!monstreTemp.equals("AucunMonstre") && Main.getP().getAtk() >= ennemi.getAtk())
        {
            texte += '\n' + ennemi.getVictoire();
        }
        else if ( !monstreTemp.equals("AucunMonstre") && Main.getP().getAtk() < ennemi.getAtk() )
        {
            Main.getP().setHp(Main.getP().getHp() - 1);
            texte += '\n' + ennemi.getDefaite();
        }
    }

    public void calculerResultatStat()
    {
        int randVal = (int)(Math.random() * (100));
        if (!stat.equals("AucuneStat") && Main.getP().getStat(stat)>=randVal)
        {
            System.out.println("Stat >= random car " + Main.getP().getStat(stat) + " >= " + randVal );
            sortieChoix2=sortieChoix1;
        }
        else if (!stat.equals("AucuneStat") && Main.getP().getStat(stat)<randVal)
        {
            System.out.println("Stat < random car " + Main.getP().getStat(stat) + " < " + randVal );
            sortieChoix1=sortieChoix2;
        }
    }

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

    public String getQcm() {
        return qcm;
    }

    public String getSortieChoix1() {
        return sortieChoix1;
    }

    public String getSortieChoix2() {
        return sortieChoix2;
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

}
