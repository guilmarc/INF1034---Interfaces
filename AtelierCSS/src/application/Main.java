package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {
	private static final int LARGEUR_SCENE = 450;
	private static final int HAUTEUR_SCENE = 250;

	private RadioButton boutonRadioPetite;
	private RadioButton boutonRadioMoyenne;
	private RadioButton boutonRadioGrande;
	private TextArea zoneTexte;

	class GestionClicBoutonRadio implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
		
			RadioButton boutonRadio = (RadioButton) event.getSource();
			zoneTexte.appendText("Changement pour taille " + boutonRadio.getText() +"\n");
		}
	}

	class GestionChoixBoiteCombo implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			ComboBox<?> boiteCombo = (ComboBox<?>) event.getSource();
			String choix = (String) boiteCombo.getValue();
			zoneTexte.appendText("Choix de type de pizza: " + choix + "\n");
			
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			Text titrePizzeria = new Text("Gino Pizzeria");
			titrePizzeria.setId("titrePizzeria");

			zoneTexte = new TextArea();
			zoneTexte.setPrefRowCount(5);

			GridPane gridPaneCentral = creerPanneauCentral();
			//gridPaneCentral.setHgap(20.0);
			gridPaneCentral.setId("gridPaneCentral");

			BorderPane root = new BorderPane();
			BorderPane.setAlignment(titrePizzeria, Pos.CENTER);
			root.setTop(titrePizzeria);
			root.setCenter(gridPaneCentral);
			root.setBottom(zoneTexte);

			Scene scene = new Scene(root, LARGEUR_SCENE, HAUTEUR_SCENE);

			scene.getStylesheets().add("/application/application.css");
			scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Candal");
			scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Sarina");

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private GridPane creerPanneauCentral() {
		GridPane gridPaneCentral = new GridPane();
		gridPaneCentral.setHgap(5);
		gridPaneCentral.setPadding(new Insets(0, 0, 10, 0));

		Text titreTaille = new Text("Taille");
		titreTaille.setId("tableauTitre");

		Text titreOptions = new Text("Options");
		titreOptions.setId("tableauTitre");

		Text titreGarniture = new Text("Garniture");
		titreGarniture.setId("tableauTitre");

		boutonRadioPetite = new RadioButton("Petite");
		boutonRadioMoyenne = new RadioButton("Moyenne");
		boutonRadioGrande = new RadioButton("Grande");

		boutonRadioMoyenne.setSelected(true);

		ToggleGroup groupeBoutonRadio = new ToggleGroup();
		boutonRadioPetite.setToggleGroup(groupeBoutonRadio);
		boutonRadioMoyenne.setToggleGroup(groupeBoutonRadio);
		boutonRadioGrande.setToggleGroup(groupeBoutonRadio);

		GestionClicBoutonRadio gestionClicBoutonRadio = new GestionClicBoutonRadio();
		boutonRadioPetite.setOnAction(gestionClicBoutonRadio);
		boutonRadioMoyenne.setOnAction(gestionClicBoutonRadio);
		boutonRadioGrande.setOnAction(gestionClicBoutonRadio);

		VBox vBoxBoutonRadio = new VBox(5);
		vBoxBoutonRadio.getChildren().addAll(boutonRadioPetite,
				boutonRadioMoyenne, boutonRadioGrande);
		CheckBox caseCocherCrouteMince = new CheckBox("Croute Mince");
		CheckBox caseCocherExtraFromage = new CheckBox("Extra fromage");

		VBox vBoxCaseCocher = new VBox(5);
		vBoxCaseCocher.getChildren().addAll(caseCocherCrouteMince,
				caseCocherExtraFromage);

		ObservableList<String> listeTypePizza = FXCollections.observableArrayList("Toute garnie", "Nature", "Pepperoni", "Québécoise", "Mexicaine", "Végétarienne", "Poulet", "Viande fumée");
		ComboBox<String> boiteTypePizza = new ComboBox<String>(listeTypePizza);

		boiteTypePizza.setEditable(false);
		boiteTypePizza.setValue("Toute garnie");
		boiteTypePizza.setOnAction(new GestionChoixBoiteCombo());

		gridPaneCentral.setAlignment(Pos.TOP_CENTER);
		gridPaneCentral.setPadding(new Insets(10,10,10,10));
		//GridPane.setHalignment(titreTaille, HPos.CENTER);
		//GridPane.setMargin(titreTaille, new Insets(0, 0, 5, 0));
		GridPane.setHalignment(titreTaille, HPos.CENTER);
		GridPane.setHalignment(titreOptions, HPos.CENTER);
		GridPane.setHalignment(titreGarniture, HPos.CENTER);

		gridPaneCentral.add(titreTaille, 0, 0,1,1);
		gridPaneCentral.add(titreOptions, 1, 0);
		gridPaneCentral.add(titreGarniture, 2, 0);
		gridPaneCentral.add(vBoxBoutonRadio, 0, 1, 1, 3);
		gridPaneCentral.add(vBoxCaseCocher, 1, 1, 1, 3);
		gridPaneCentral.add(boiteTypePizza, 2, 1);

		return gridPaneCentral;

	}
}
