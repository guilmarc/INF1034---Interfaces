package Controller;

import javafx.stage.Stage;

public class ChangeWindowsController {


    private Main main;

    public void setMain(Main main, Stage primaryStage){
        this.main = main;
    }

    public void goBack() {
        main.firstWindows();
    }
}
