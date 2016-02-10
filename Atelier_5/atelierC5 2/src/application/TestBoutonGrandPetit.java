package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class TestBoutonGrandPetit extends Application {
	
	private static final int HAUTEUR_FENETRE = 200;
	private static final int LARGEUR_FENETRE = 400;
	private static final int HAUTEUR_B_PETIT = 50;
	private static final int LARGEUR_B_PETIT = 100;
	
	Button bChTaille;
	TextField tfNbClic;
	BorderPane root;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			bChTaille = new Button("J'agrandis");
			bChTaille.setPrefSize(LARGEUR_B_PETIT, HAUTEUR_B_PETIT);
			
			root = new BorderPane();
			root.setCenter(bChTaille);
			Scene scene = new Scene(root,LARGEUR_FENETRE, HAUTEUR_FENETRE);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Fenêtre Bouton J'agrandis");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
