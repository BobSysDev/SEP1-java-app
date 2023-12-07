package view;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableSelectionExample extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Table Selection Example");

    TableView<Person> table = new TableView<>();
    table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
    firstNameCol.setCellValueFactory(data -> data.getValue().firstNameProperty());

    TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
    lastNameCol.setCellValueFactory(data -> data.getValue().lastNameProperty());

    table.getColumns().addAll(firstNameCol, lastNameCol);

    ObservableList<Person> data = FXCollections.observableArrayList(
        new Person("John", "Doe"),
        new Person("Jane", "Doe"),
        new Person("Bob", "Smith")
    );

    table.setItems(data);

    Button myButton = new Button("Enable Me");
    myButton.setDisable(true);

    table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if (newSelection != null) {
        myButton.setDisable(false);
      } else {
        myButton.setDisable(true);
      }
    });

    VBox vbox = new VBox(table, myButton);
    Scene scene = new Scene(vbox, 300, 200);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  public static class Person {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;

    public Person(String firstName, String lastName) {
      this.firstName = new SimpleStringProperty(firstName);
      this.lastName = new SimpleStringProperty(lastName);
    }

    public String getFirstName() {
      return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
      return firstName;
    }

    public String getLastName() {
      return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
      return lastName;
    }
  }
}
