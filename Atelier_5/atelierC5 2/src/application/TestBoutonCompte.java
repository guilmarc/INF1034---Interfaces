package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;


public class TestBoutonCompte extends Application {
	
	private static final int LARGEUR_SCENE = 300;
	private static final int HAUTEUR_SCENE = 50;
	
	Button bCompte;
	TextField tfNbClic;


	@Override
	public void start(Stage primaryStage) {
		try {
			bCompte = new Button("Je compte");
			tfNbClic = new TextField("0 clic");
			tfNbClic.setEditable(false);
			
			FlowPane root = new FlowPane();
			root.setHgap(5);
			root.getChildren().addAll(bCompte, tfNbClic);
			Scene scene = new Scene(root,LARGEUR_SCENE,HAUTEUR_SCENE);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Fenêtre Bouton Je Compte");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
