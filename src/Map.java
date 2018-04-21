public class Map {

    public Map( String _entree , String _texte , String _image , String _qcm , String _choix)
    {
        entree=_entree;
        texte=_texte;
        image="TheLostAshes2/files/" + _image;
        qcm=_qcm;
        choix=_choix;
    }

    private String entree;
    private String sortie;
    private String texte;
    private String image;
    private String qcm;
    private String choix;

    public String getEntree() {
        return entree;
    }

    public void setSortie(String sortie) {
        this.sortie = sortie;
    }

    public String getSortie() {
        return sortie;
    }

    public String getTexte() {
        return texte;
    }

    public String getChoix() {
        return choix;
    }

    public String getImage() {
        return image;
    }

    public String getQcm() {
        return qcm;
    }
}