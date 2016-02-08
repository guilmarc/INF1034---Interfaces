package Controller;

import javafx.stage.Stage;

public class FirstWindowsController {


    private Main main;

    public void setMain(Main main, Stage primaryStage){
        this.main = main;
    }

    //Open any number of instance of new Window
    public void openNewWindow() {
        main.secondWindows();
    }

    public void changeWindow(){

    }
}
