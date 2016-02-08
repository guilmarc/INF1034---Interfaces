package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class Main extends Application {

    //Let it available for the rest of the program
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        mainWindows();
    }

    public void mainWindows(){

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/MainWindowsView.fxml"));
            AnchorPane pane = loader.load();
            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(this, primaryStage);

            Scene scene = new Scene(pane);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Force the Canada date and locale format
        Locale.setDefault(Locale.CANADA);
        launch(args);
    }
}
