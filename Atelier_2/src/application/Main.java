package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			final int SCENE_WIDTH = 300;
			final int SCENE_HEIGHT = 275;
			final int GLOBAL_PADING = 10;

			Text scenetitle = new Text("Bienvenue");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

			TextField userTextField = new TextField();
			Label usernameLabel = new Label("_Utilisateur:");
			usernameLabel.setLabelFor(userTextField);
			usernameLabel.setMnemonicParsing(true);

			Label passwordLabel = new Label("_Mot de passe:");
			PasswordField passwordField = new PasswordField();
			passwordLabel.setLabelFor(passwordField);
			passwordLabel.setMnemonicParsing(true);
			
			Button btn = new Button("Connecter");
			final Text actionTarget = new Text();
	        
			btn.setOnAction(new EventHandler<ActionEvent>() {	 
			    @Override
			    public void handle(ActionEvent e) {
			        actionTarget.setFill(Color.FIREBRICK);
			        actionTarget.setText("Bouton connecter appuyé");
			    }
			});
			
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
				
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(GLOBAL_PADING, GLOBAL_PADING, GLOBAL_PADING, GLOBAL_PADING));
		    //grid.setGridLinesVisible(true);
		    
			grid.add(scenetitle, 0, 0, 2, 1);
			grid.add(usernameLabel, 0, 1);
			grid.add(userTextField, 1, 1);
			grid.add(passwordLabel, 0, 2);
			grid.add(passwordField, 1, 2);
			grid.add(hbBtn, 1, 4);
			grid.add(actionTarget, 0, 6, 2, 1);
						
			Scene scene = new Scene(grid,SCENE_WIDTH,SCENE_HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Bienvenue au café des effets spéciaux");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
