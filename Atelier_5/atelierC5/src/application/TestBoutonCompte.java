package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;


public class TestBoutonCompte extends Application {
	
	private static final int LARGEUR_SCENE = 300;
	private static final int HAUTEUR_SCENE = 50;

	Button bRAZ;
	Button bCompte;
	TextField tfNbClic;

	class OnClickEventHandler implements EventHandler {
		int nbClic = 0;
		@Override
		public void handle(Event event) {

			if (event.getSource().equals(bRAZ)) {
				bRAZ.setDisable(true);
				nbClic = 0;
			} else {
				bRAZ.setDisable(false);
				nbClic++;
			}

			tfNbClic.setText(nbClic + " clic" + (nbClic > 1 ? "s" : ""));

		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			bCompte = new Button("Je compte");
			bRAZ = new Button("RAZ");
			tfNbClic = new TextField("0 clic");
			tfNbClic.setEditable(false);


			OnClickEventHandler onClickEventHandler = new OnClickEventHandler();

			bRAZ.setOnAction(onClickEventHandler);
			bCompte.setOnAction(onClickEventHandler);
			bRAZ.setDisable(true);

			FlowPane root = new FlowPane();
			root.setHgap(5);
			root.getChildren().addAll(bCompte, tfNbClic, bRAZ);
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
