package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    //Let it available for the rest of the program
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        firstWindows();
    }

    public void changeWindow(){

    }

    public void firstWindows(){

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/FirstWindowView.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);

            //Forcing a .css file
            scene.getStylesheets().add(getClass().getResource("stype.css").toExternalForm());

            FirstWindowsController firstWindowsController = loader.getController();
            firstWindowsController.setMain(this, primaryStage);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void secondWindows(){

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/SecondWindowView.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);

            Stage secondaryStage = new Stage();
            secondaryStage.initOwner(primaryStage);
            secondaryStage.initModality(Modality.WINDOW_MODAL);


            SecondWindowsController secondWindowsController = loader.getController();
            secondWindowsController.setMain(this, secondaryStage);

            secondaryStage.setScene(scene);
            secondaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
