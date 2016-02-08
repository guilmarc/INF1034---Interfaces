package Controller;

import Model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Optional;

public class MainWindowController {


    //Views
    @FXML private Label label;
    @FXML private TextField field;

    @FXML private TableView tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, String> ageColumn;

    @FXML private DatePicker datePicker;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    private Person person;

    private Main main;
    private Stage primaryStage;

    //Will be called automatically
    public void initialize(){
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
    }

    public void setMain(Main main, Stage primaryStage){
        this.main = main;
        this.primaryStage = primaryStage;
        person = new Person("Marco", "Guilmette", "37");
        this.setTableData();
        tableView.setItems(personList);
        datePicker.setValue(LocalDate.now());
        datePicker.setShowWeekNumbers(false);
        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
            System.out.print(date);
        });
    }

    public void setTableData() {
        personList.add(new Person("Marco","Guilmette","37"));
        personList.add(new Person("Geneviève","Beaudoin","40"));
        personList.add(new Person("Alain","Côté","40"));
        personList.add(new Person("Sonia","Brouillette","37"));
        personList.add(new Person("Anthony","Desmarais","10"));
        personList.add(new Person("Karima","Desmarais","11"));
        personList.add(new Person("Stéphane","Desmarais","38"));
        personList.add(new Person("Nicole","Leblanc","63"));
        personList.add(new Person("Francine","Lacourge","62"));
        personList.add(new Person("Robert","D'Auteuil","54"));
    }

    public void HandleCloseButtonAction(){
        primaryStage.close();
    }

    public void handleButton(){
        String text = field.getText();

        label.setText(person.getFirstName() + " " + person.getLastName());
        field.clear();
    }


    public void HandleAlert1Action(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information header text");
        alert.setContentText("This is the information text that is displayed to the user");
        alert.showAndWait();
    }

    public void HandleAlert2Action(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Warning header");
        alert.setContentText("A serious warning");
        alert.showAndWait();
    }

    public void HandleAlert3Action(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Confirmation");
        alert.setContentText("I confirm this notice");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.out.println("OK Clicked !");
        } else {
            System.out.println("Cancel clicked !");
        }
    }

    public void HandleAlert4Action(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input");
        dialog.setContentText("Please enter your age: ");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.print(result);
        } else {
            System.out.print("NO INPUT");
        }
    }
}
