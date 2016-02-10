package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
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
	private static final int HAUTEUR_B_GRAND = 75;
	private static final int LARGEUR_B_GRAND = 200;

	Button bChTaille;
	TextField tfNbClic;
	BorderPane root;

	class OnClickEventHandler implements EventHandler {
		public void handle(Event event){
			bChTaille.setText((bChTaille.getPrefHeight() == HAUTEUR_B_PETIT) ? "Je rétrécis" : "J'agrandis");
			bChTaille.setPrefHeight(((bChTaille.getPrefHeight() == HAUTEUR_B_PETIT) ? HAUTEUR_B_GRAND : HAUTEUR_B_PETIT));
			bChTaille.setPrefWidth(((bChTaille.getPrefWidth() == LARGEUR_B_PETIT) ? LARGEUR_B_GRAND : LARGEUR_B_PETIT));
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			bChTaille = new Button("J'agrandis");
			bChTaille.setPrefSize(LARGEUR_B_PETIT, HAUTEUR_B_PETIT);
			bChTaille.setOnAction(new OnClickEventHandler());
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