import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private static Personnage P = new Personnage();
    private static Monde M;

    static {
            M = new Monde();
    }


    private Group root = new Group();
    private Text text;
    private Text stats= new Text(20,50,"");
    private Text qcm;
    private StackPane P1;
    private StackPane P2;
    private Button b1;
    private Button b2;
    private String Class = "Aucune";
    private ArrayList<Integer> guerrierStats = new ArrayList<>();
    private ArrayList<Integer> archerStats = new ArrayList<>();
    private ArrayList<Integer> pretreStats = new ArrayList<>();
    private ArrayList<Integer> mageStats = new ArrayList<>();
    private Alert alertName = new Alert(Alert.AlertType.ERROR);
    private Alert alertClass = new Alert(Alert.AlertType.ERROR);





    public static void main (String[] args) throws IOException
    {
        M.buildWorld();
        M.buildEnnemi();
        Application.launch();
    }

    public void start (Stage primaryStage)
    {
        primaryStage.setTitle("The Lost Ashes");

        Scene scene = new Scene(root, 1280, 720, Color.GREY);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        afficherDecor();

        //Titre
        Text welcomeText = new Text("Création du Personnage ");
        welcomeText.setX(480);
        welcomeText.setY(120);
        welcomeText.setStyle("-fx-font-size : 24");
        welcomeText.setFont(new Font("Calibri" , 30));
        root.getChildren().add(welcomeText);

        //Nom
        TextField nom = new TextField();
        nom.relocate(600,200);
        root.getChildren().add(nom);
        Text texteNom = new Text("Pseudo");
        texteNom.setX(450);
        texteNom.setY(220);
        texteNom.setFont(new Font("Calibri",18));
        root.getChildren().add(texteNom);


        //Nom des Classes
        /*
        Text nomClasses = new Text("Guerrier\t\t\tArcher\t\t\tPrêtre\t\t\tMage");
        nomClasses.relocate(430,280);
        nomClasses.setFont(new Font ("Calibri",18));
        root.getChildren().add(nomClasses);
        */

        //Stats

        guerrierStats.add(4);
        guerrierStats.add(5);
        guerrierStats.add(10);
        guerrierStats.add(40);
        guerrierStats.add(70);

        archerStats.add(5);
        archerStats.add(4);
        archerStats.add(25);
        archerStats.add(10);
        archerStats.add(90);

        pretreStats.add(3);
        pretreStats.add(6);
        pretreStats.add(30);
        pretreStats.add(80);
        pretreStats.add(60);

        mageStats.add(6);
        mageStats.add(3);
        mageStats.add(80);
        mageStats.add(25);
        mageStats.add(10);


        /*
        Text stats = new Text(
                        "Attaque \t\t\t\t"+guerrierStats.get(0)+"\t\t\t\t\t"+archerStats.get(0)+"\t\t\t\t\t"+pretreStats.get(0)+" \t\t\t\t\t"+mageStats.get(0) +"\n\n" +
                        "HP      \t\t\t\t"+guerrierStats.get(1)+"\t\t\t\t\t"+archerStats.get(1)+"\t\t\t\t\t"+pretreStats.get(1)+" \t\t\t\t\t"+mageStats.get(1) +"\n\n" +
                        "Magie   \t\t\t\t"+guerrierStats.get(2)+"\t\t\t\t\t"+archerStats.get(2)+"\t\t\t\t\t"+pretreStats.get(2)+" \t\t\t\t\t"+mageStats.get(2) +"\n\n" +
                        "Foi     \t\t\t\t"+guerrierStats.get(3)+"\t\t\t\t\t"+archerStats.get(3)+"\t\t\t\t\t"+pretreStats.get(3)+" \t\t\t\t\t"+mageStats.get(3) +"\n\n" +
                        "Charisme  \t\t\t"+guerrierStats.get(4)+"\t\t\t\t\t"+archerStats.get(4)+"\t\t\t\t\t"+pretreStats.get(4)+" \t\t\t\t\t"+mageStats.get(4) +"\n\n");
        stats.relocate(300,350);
        stats.setFont(new Font ("Calibri",15));
        root.getChildren().add(stats);
        */

        VBox stats = new VBox();

        HBox header = new HBox();
        HBox atk = new HBox();
        HBox hp = new HBox();
        HBox magie = new HBox();
        HBox foi = new HBox();
        HBox charisme = new HBox();



        Text emptyHeader = new Text("                ");
        Text guerrierHeader = new Text("Attaque  ");
        Text archerHeader = new Text("HP    ");
        Text pretreHeader = new Text("Magie  ");
        Text mageHeader = new Text("Foi      ");

        Text statAtkHeader = new Text("Attaque");
        Text atkGuerrier = new Text(guerrierStats.get(0).toString());
        Text atkArcher = new Text(archerStats.get(0).toString());
        Text atkPretre = new Text(pretreStats.get(0).toString());
        Text atkMage = new Text(mageStats.get(0).toString());

        Text statHpHeader = new Text("Hp        ");
        Text hpGuerrier = new Text(guerrierStats.get(1).toString());
        Text hpArcher = new Text(archerStats.get(1).toString());
        Text hpPretre = new Text(pretreStats.get(1).toString());
        Text hpMage = new Text(mageStats.get(1).toString());

        Text statMagieHeader = new Text("Magie    ");
        Text magieGuerrier = new Text(guerrierStats.get(2).toString());
        Text magieArcher = new Text(archerStats.get(2).toString());
        Text magiePretre = new Text(pretreStats.get(2).toString());
        Text magieMage = new Text(mageStats.get(2).toString());

        header.getChildren().addAll(emptyHeader,guerrierHeader,archerHeader,pretreHeader,mageHeader);
        header.setSpacing(85);
        atk.getChildren().addAll(statAtkHeader,atkGuerrier,atkArcher,atkPretre,atkMage);
        atk.setSpacing(120);
        hp.getChildren().addAll(statHpHeader,hpGuerrier,hpArcher,hpPretre,hpMage);
        hp.setSpacing(120);
        magie.getChildren().addAll(statMagieHeader,magieGuerrier,magieArcher,magiePretre,magieMage);
        magie.setSpacing(112);

        stats.getChildren().add(header);
        stats.getChildren().add(atk);
        stats.getChildren().add(hp);
        stats.getChildren().add(magie);
        stats.relocate(300,280);
        stats.setSpacing(20);
        root.getChildren().add(stats);



        HBox boutons = new HBox();
        boutons.setSpacing(106);
        boutons.relocate(465,550);
        CheckBox Guerrier = new CheckBox();
        CheckBox Archer = new CheckBox();
        CheckBox Mage = new CheckBox();
        CheckBox Pretre = new CheckBox();
        boutons.getChildren().addAll(Guerrier,Archer,Mage,Pretre);
        root.getChildren().add(boutons);


        Guerrier.setOnAction((event -> {
            Archer.setSelected(false);
            Mage.setSelected(false);
            Pretre.setSelected(false);
            Class = "Guerrier";
        }));
        Archer.setOnAction((event -> {
            Guerrier.setSelected(false);
            Mage.setSelected(false);
            Pretre.setSelected(false);
            Class = "Archer";
        }));
        Pretre.setOnAction((event -> {
            Archer.setSelected(false);
            Mage.setSelected(false);
            Guerrier.setSelected(false);
            Class = "Prêtre";
        }));
        Mage.setOnAction((event -> {
            Archer.setSelected(false);
            Guerrier.setSelected(false);
            Pretre.setSelected(false);
            Class = "Mage";
        }));


        Button valider = new Button("Valider");
        valider.relocate(580,600);
        valider.resize(100,100);
        root.getChildren().add(valider);



        alertClass.setTitle("Erreur !");
        alertClass.setHeaderText("Merci de choisir une classe !");
        alertClass.setContentText("Si vous ne savez pas quoi choisir , prenez prêtre , personne ne prend prêtre.");

        alertName.setTitle("Erreur !");
        alertName.setHeaderText("Merci d'entrer un pseudo !");
        alertName.setContentText("Si vous n'avez pas d'inspiration , appellez vous xXDarkSasukeXx...");


        //Test de pression de bouton
        valider.setOnAction((event)->
        {
            P.setName(nom.getText());
            if (!Class.equals("Aucune") && !P.getName().equals("")) {
                calculerStats();
                M.setCurrentSortie("Entree");
                initMapDecorStat();
                preparerBoutons();
                System.out.println(P.getStat("magie") + P.getStat("foi") + P.getStat("charisme"));
            }
            else if (Class.equals("Aucune"))
                alertClass.showAndWait();
            else
                alertName.showAndWait();
        });


        //Test de pression de touche
        nom.setOnKeyReleased(new EventHandler<KeyEvent>() {
            final KeyCombination combo = new KeyCodeCombination(KeyCode.ENTER);
            public void handle(KeyEvent t) {
                if (combo.match(t))
                {
                    P.setName(nom.getText());
                    if (!Class.equals("Aucune") && !P.getName().equals("")) {

                        calculerStats();
                        M.setCurrentSortie("Entree");
                        initMapDecorStat();
                        preparerBoutons();
                    }
                    else if (Class.equals("Aucune"))
                        alertClass.showAndWait();
                    else if (P.getName().equals(""))
                        alertName.showAndWait();
                }
            }
        });

        primaryStage.show();
    }


    public void calculerStats ()
    {
        switch (Class)
        {
            case "Guerrier":
                P.setAtk(guerrierStats.get(0));
                P.setHp(guerrierStats.get(1));
                P.setMagie(guerrierStats.get(2));
                P.setFoi(guerrierStats.get(3));
                P.setCharisme(guerrierStats.get(4));
                break;
            case "Archer":
                P.setAtk(archerStats.get(0));
                P.setHp(archerStats.get(1));
                P.setMagie(archerStats.get(2));
                P.setFoi(archerStats.get(3));
                P.setCharisme(archerStats.get(4));
                break;
            case "Prêtre":
                P.setAtk(pretreStats.get(0));
                P.setHp(pretreStats.get(1));
                P.setMagie(pretreStats.get(2));
                P.setFoi(pretreStats.get(3));
                P.setCharisme(pretreStats.get(4));
                break;
            case "Mage":
                P.setAtk(mageStats.get(0));
                P.setHp(mageStats.get(1));
                P.setMagie(mageStats.get(2));
                P.setFoi(mageStats.get(3));
                P.setCharisme(mageStats.get(4));
                break;
        }
    }
    public void preparerBoutons()
    {
        b1.setOnAction((event) ->
        {
            M.getCurrentMap().checkVictoireDefaite();
            if (!M.isVictoire() && !M.isDefaite() && P.getHp() > 0) {
                M.setCurrentSortie(M.getTabMaps().get(M.getCurrentIndice()).getSortieChoix1());
            }
            else if (M.isDefaite() || P.getHp() <= 0)
                M.setCurrentSortie("Defaite");
            else
                M.setCurrentSortie("Victoire");
            choisirMap();
            afficherMap();

        });

        b2.setOnAction((event) ->
        {
            M.getCurrentMap().checkVictoireDefaite();
            if (!M.isVictoire() && !M.isDefaite() && P.getHp() > 0) {
                M.setCurrentSortie(M.getTabMaps().get(M.getCurrentIndice()).getSortieChoix2());
            }
            else if (M.isDefaite() || P.getHp() <= 0)
                M.setCurrentSortie("Defaite");
            else
                M.setCurrentSortie("Victoire");
            choisirMap();
            afficherMap();
            afficherStats();

        });
    }

    public void choisirMap ()
    {
        Map[] maps=new Map[50];
        int compteur = 0 ;

        for (int i=0;i<M.getTabMaps().size();++i)
        {
            if (M.getTabMaps().get(i).getEntree().replaceAll("[^\\x20-\\x7e]", "").equals(M.getCurrentSortie().replaceAll("[^\\x20-\\x7e]", "")))
            {
                maps[compteur]=M.getTabMaps().get(i);
                ++compteur;
            }
        }
        int randVal = (int)(Math.random() * (compteur));
        M.setCurrentMap(maps[randVal]);
        M.getCurrentMap().trouverMonstre();
        M.getCurrentMap().calculerResultatCombat();
        M.getCurrentMap().calculerResultatStat();

    }

    public void initMap ()
    {

        root.getChildren().clear();
        afficherDecor();
        text = new Text(50,450,M.getCurrentMap().getTexte());
        text.setFont(new Font("Calibri" ,13));

        qcm = new Text(50,530,M.getCurrentMap().getQcm());

        b1 = new Button(M.getTabMaps().get(M.getCurrentIndice()).getChoix1());
        b2 = new Button(M.getTabMaps().get(M.getCurrentIndice()).getChoix2());

        P1 = new StackPane();
        P1.getChildren().add(b1);
        P1.setLayoutX(200);
        P1.setLayoutY(550);

        P2 = new StackPane();
        P2.getChildren().add(b2);
        P2.setLayoutX(500);
        P2.setLayoutY(550);
    }

    public void afficherDecor ()
    {
        Rectangle rectGauche = new Rectangle(10,10,250,700);
        rectGauche.setFill(Color.TRANSPARENT);
        rectGauche.setStroke(Color.GOLD);
        root.getChildren().add(rectGauche);

        Rectangle rectDroite = new Rectangle(1020,10,250,700);
        rectDroite.setFill(Color.TRANSPARENT);
        rectDroite.setStroke(Color.GOLD);
        root.getChildren().add(rectDroite);

        Rectangle rectBas = new Rectangle(270,70,740,640);
        rectBas.setFill(Color.TRANSPARENT);
        rectBas.setStroke(Color.BLACK);
        rectBas.setArcWidth(30.0);
        rectBas.setArcHeight(20.0);
        root.getChildren().add(rectBas);


    }

    public void afficherStats()
    {
        stats.setText("Nom: "+ P.getName() +"\n \n \nAttaque : " + P.getAtk() +"\n \nHP : " + P.getHp());
        stats.setFill(Color.BLACK);
    }

    public void afficherMap()
    {
        if (!M.isDefaite() && !M.isVictoire()) {
            text.setText(M.getCurrentMap().getTexte());
            qcm.setText(M.getCurrentMap().getQcm());
            b1.setText(M.getTabMaps().get(M.getCurrentIndice()).getChoix1());
            b2.setText(M.getTabMaps().get(M.getCurrentIndice()).getChoix2());
        }
        else if (M.isDefaite()) {
            text.setText("Vous avez perdu !");
            qcm.setText("Appuyez a nouveau sur un bouton pour rejouer :)");
            b1.setText("Rejouer");
            b2.setText("Rejouer");
            M.setDefaite(false);
            M.setVictoire(false);
        }
        else if (M.isVictoire())
            {
                text.setText("Vous avez gagné !");
                qcm.setText("Appuyez a nouveau sur un bouton pour rejouer :)");
                b1.setText("Rejouer");
                b2.setText("Rejouer");
                M.setDefaite(false);
                M.setVictoire(false);
            }
        }

    public void initMapDecorStat()
    {

        choisirMap();
        afficherDecor();
        initMap();
        afficherStats();

        root.getChildren().add(text);
        root.getChildren().add(qcm);
        root.getChildren().add(P1);
        root.getChildren().add(P2);
    }

    public static Personnage getP()
    {
        return P;
    }

    public static Monde getM()
    {
        return M;
    }

}
