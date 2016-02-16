package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	private static final int LARGEUR_SCENE = 400;
	private static final int HAUTEUR_SCENE = 200;

	private  RadioButton 	boutonRadioPetite,
	 						boutonRadioMoyenne,
							boutonRadioGrande;

	TextArea textArea;

	EventHandler eventHandler = new EventHandler() {

		public void handle(Event event) {
			if (event.getSource() instanceof RadioButton) {
				textArea.appendText("Changement pour taille " + ((RadioButton)event.getSource()).getText() + "\n");
			}
			if (event.getSource() instanceof ComboBox) {
				textArea.appendText("Choix de type de pizza:  " + ((ComboBox)event.getSource()).getValue() + "\n");
			}
		}
	};


	@Override
	public void start(Stage primaryStage) {
		try {
			Text titrePizzaria = new Text("Pizzaria GUI");

			GridPane gridPane = creerPanneauCentral();

			BorderPane root = new BorderPane();
			BorderPane.setAlignment(titrePizzaria, Pos.CENTER);
			root.setTop(titrePizzaria);

			gridPane.setPadding(new Insets(10,10,10,10));

			root.setCenter(gridPane);
			textArea = new TextArea();
			root.setBottom(textArea);

			Scene scene = new Scene(root,LARGEUR_SCENE,HAUTEUR_SCENE);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private GridPane creerPanneauCentral(){
		GridPane gridPaneCentral = new GridPane();

		Text titreTaille = new Text("Taille");

		boutonRadioPetite = new RadioButton("Petite");
		boutonRadioMoyenne = new RadioButton("Moyenne");
		boutonRadioGrande = new RadioButton("Grande");

		boutonRadioMoyenne.setSelected(true);

		ToggleGroup groupeBoutonRadio = new ToggleGroup();
		boutonRadioPetite.setToggleGroup(groupeBoutonRadio);
		boutonRadioMoyenne.setToggleGroup(groupeBoutonRadio);
		boutonRadioGrande.setToggleGroup(groupeBoutonRadio);

		boutonRadioPetite.setOnAction(eventHandler);
		boutonRadioMoyenne.setOnAction(eventHandler);
		boutonRadioGrande.setOnAction(eventHandler);

		VBox vBoxBoutonRadio = new VBox(5);
		vBoxBoutonRadio.getChildren().addAll(boutonRadioPetite,boutonRadioMoyenne,boutonRadioGrande);
		CheckBox caseCocherCrouteMince = new CheckBox("Croute Mince");
		CheckBox caseCocherExtraFromage = new CheckBox("Extra fromage");

		VBox vBoxCaseCocher = new VBox(5);
		vBoxCaseCocher.setId("vBoxCaseCocher");
		vBoxCaseCocher.getChildren().addAll(caseCocherCrouteMince, caseCocherExtraFromage);


		ComboBox comboBox = new ComboBox();
		comboBox.getItems().addAll(
				" Toute garnie",
				"Nature",
				"Pepperoni",
				"Québécoise",
				"Mexicaine",
				"Végétarienne",
				"Poulet",
				"Viande fumée"
		);
		comboBox.setOnAction(eventHandler);


		GridPane.setMargin(titreTaille, new Insets(0,0,10,0));

		GridPane.setHalignment(titreTaille, HPos.CENTER);
		gridPaneCentral.setGridLinesVisible(true);
		gridPaneCentral.setAlignment(Pos.TOP_CENTER);
		gridPaneCentral.add(titreTaille,0,0);
		gridPaneCentral.add(vBoxBoutonRadio,0,1,1,3);
		gridPaneCentral.add(vBoxCaseCocher,1,1,1,3);
		gridPaneCentral.add(comboBox,2,1);

		return gridPaneCentral;
	}
}
