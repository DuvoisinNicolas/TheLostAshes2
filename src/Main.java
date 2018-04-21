import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
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
                    System.out.println("mdr");

                    M.setCurrentSortie("Entree");


                    System.out.println("mdr");
                    root.getChildren().clear();
                    System.out.println("mdr");
                    choisirMap();
                    System.out.println("mdr");
                    afficherMap();
                    System.out.println("mdr");
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
        int compteur=0,randVal=0;

        for (int i=0;i<M.getTabMaps().length;++i)
        {
            if (M.getTabMaps()[i].getEntree().equals(M.getCurrentSortie()))
            {
                maps[compteur]=M.getTabMaps()[i];
            }
        }
        randVal = (int)(Math.random() * (compteur));
        M.setCurrentMap(M.getTabMaps()[randVal]);
    }

    public void afficherMap ()
    {
        Text texte = new Text(50,450,M.getCurrentMap().getTexte());
        texte.setFill(Color.RED);
        root.getChildren().add(texte);

    }
}
