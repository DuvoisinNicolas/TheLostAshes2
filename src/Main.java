import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    private static Personnage P = new Personnage();
    private static Monde M;

    static {
        try {
            M = new Monde();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Group root = new Group();


    private static Text text;
    private Text stats= new Text(20,50,"");
    private Text qcm;
    private StackPane P1;
    private StackPane P2;
    private Button b1;
    private Button b2;


    public static void main (String[] args) throws IOException {
        M.buildChapitre();
        M.buildWorld();
        M.buildEnnemi();
        Application.launch();
    }

    public void start (Stage primaryStage)
    {
        primaryStage.setTitle("The Lost Ashes");

        Scene scene = new Scene(root, 800, 600, Color.GREY);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        afficherDecor();

        Text welcomeText = new Text("Entrez votre nom :");
        welcomeText.setX(280);
        welcomeText.setY(200);
        welcomeText.setStyle("-fx-font-size : 24");
        welcomeText.setFont(new Font("Calibri" , 30));
        root.getChildren().add(welcomeText);

        TextField nom = new TextField();
        nom.relocate(280,300);
        root.getChildren().add(nom);

        Button valider = new Button("Valider");
        valider.relocate(450,300);
        root.getChildren().add(valider);
        root.getChildren().add(stats);


        //Test de pression de bouton
        valider.setOnAction((event)->
        {
                P.setName(nom.getText());
                M.setCurrentSortie("Entree");
                root.getChildren().clear();
                initMapDecorStat();
                preparerBoutons();

        });


        //Test de pression de touche
        nom.setOnKeyReleased(new EventHandler<KeyEvent>() {
            final KeyCombination combo = new KeyCodeCombination(KeyCode.ENTER);
            public void handle(KeyEvent t) {
                if (combo.match(t))
                {
                    P.setName(nom.getText());
                    M.setCurrentSortie("Entree");
                    initMapDecorStat();
                    preparerBoutons();
                }
            }
        });


        primaryStage.show();
        }

    public void preparerBoutons()
    {
        b1.setOnAction((event) ->
        {
            M.setCurrentSortie(M.getTabMaps().get(M.getCurrentIndice()).getSortieChoix1());
            choisirMap();
            afficherMap();

        });

        b2.setOnAction((event) ->
        {
            M.setCurrentSortie(M.getTabMaps().get(M.getCurrentIndice()).getSortieChoix2());
            choisirMap();
            afficherMap();
        });
    }

    public void choisirMap ()
    {
        Map[] maps=new Map[50];
        int compteur = 0 ;

        for (int i=0;i<M.getTabMaps().size();++i)
        {
            if (M.getTabMaps().get(i).getEntree().equals(M.getCurrentSortie()) && !M.getTabMaps().get(i).getVisite())
            {
                maps[compteur]=M.getTabMaps().get(i);
                ++compteur;
            }
        }
        int randVal = (int)(Math.random() * (compteur));

        M.setCurrentMap(maps[randVal]);

        M.getCurrentMap().calculerResultatCombat();
        afficherStats();
        M.getTabMaps().get(M.getCurrentIndice()).setVisite(true);
    }


    public void initMap ()
    {
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

    public static Monde getM() {
        return M;
    }

    public void afficherDecor ()
    {
        Rectangle rectGauche = new Rectangle(10,10,150,400);
        rectGauche.setFill(Color.TRANSPARENT);
        rectGauche.setStroke(Color.BLACK);
        rectGauche.setArcWidth(30.0);
        rectGauche.setArcHeight(20.0);
        root.getChildren().add(rectGauche);

        Rectangle rectDroite = new Rectangle(640,10,150,400);
        rectDroite.setFill(Color.TRANSPARENT);
        rectDroite.setStroke(Color.BLACK);
        rectDroite.setArcWidth(30.0);
        rectDroite.setArcHeight(20.0);
        root.getChildren().add(rectDroite);

        Rectangle rectBas = new Rectangle(10,420,780,170);
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
        text.setText(M.getCurrentMap().getTexte());
        qcm.setText(M.getCurrentMap().getQcm());
        b1.setText(M.getTabMaps().get(M.getCurrentIndice()).getChoix1());
        b2.setText(M.getTabMaps().get(M.getCurrentIndice()).getChoix2());
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

    public static Personnage getP() {
        return P;
    }


}
