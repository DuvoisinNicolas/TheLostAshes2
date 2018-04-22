import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class Main extends Application {

    private static Personnage P = new Personnage();
    private static Monde M = new Monde();
    private Group root = new Group();

    public static void main (String[] args)
    {
        Application.launch();
        System.out.println(P.getName());
    }

    public void start (Stage primaryStage)
    {
        primaryStage.setTitle("The Lost Ashes");

        Scene scene = new Scene(root, 800, 600, Color.GREY);
        primaryStage.setScene(scene);

        afficherDecor();

        TextField nom = new TextField();
        nom.relocate(280,300);
        root.getChildren().add(nom);

        Button valider = new Button("Valider");
        valider.relocate(450,300);

        //Test de pression de bouton
        valider.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {
                P.setName(nom.getText());
            }
        });

        //Test de pression de touche
        nom.setOnKeyReleased(new EventHandler<KeyEvent>() {
            final KeyCombination combo = new KeyCodeCombination(KeyCode.ENTER);
            public void handle(KeyEvent t) {
                if (combo.match(t))
                {
                    P.setName(nom.getText());
                    M.setCurrentSortie("Entree");
                    root.getChildren().clear();
                    afficherMapDecorStat();
                    primaryStage.show();

                }
            }
        });

        root.getChildren().add(valider);

        primaryStage.show();


    }

    public void choisirMap ()
    {
        Map[] maps=new Map[50];
        int compteur = 0 , randVal =0;

        for (int i=0;i<M.getTabMaps().size();++i)
        {
            if (M.getTabMaps().get(i).getEntree().equals(M.getCurrentSortie()))
            {
                maps[compteur]=M.getTabMaps().get(i);
                ++compteur;
            }
        }
        randVal = (int)(Math.random() * (compteur));
        M.setCurrentMap(M.getTabMaps().get(randVal));
    }

    public void afficherMap ()
    {
        Text texte = new Text(50,450,M.getCurrentMap().getTexte());
        texte.setFill(Color.RED);
        root.getChildren().add(texte);

        Image img = new Image(M.getTabMaps().get(M.getCurrentIndice()).getImage(),400,400,true,true);

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
        Text stats = new Text(20,50,"Nom: "+ P.getName() +"\n \n \nAttaque : " + P.getAtk() + "\n \nDéfense : " + P.getDef() + "\n \nHP : " + P.getHp());
        stats.setFill(Color.RED);
        root.getChildren().add(stats);
    }

    public void afficherMapDecorStat()
    {
        choisirMap();
        afficherDecor();
        afficherMap();
        afficherStats();
    }
}
