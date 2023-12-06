package view;
import javafx.fxml.FXML;
import javafx.scene.SnapshotResult;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import model.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.event.ActionEvent;


import java.util.Optional;

public class NewProjectViewController
{
  @FXML private TextField nameTextField;
  @FXML private Label typeLabel;
  @FXML private TextField customerTextField;
  @FXML private TextField eBudgetTextField;
  @FXML private TextField eManHoursTextField;
  @FXML private TextField sizeTextField;
  @FXML private TextField materialsTextField;
  @FXML private TextField detailsTextField;

  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;
  private ProjectListViewModel ongoingViewModel;

  public NewProjectViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler)
  {
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
  }

  public void reset(){
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

  public void setDefaults(String type){
    switch (type){
      case ("Residential"):
        typeLabel.setText(type);
        eBudgetTextField.setText("400 000");
        eManHoursTextField.setText("20 000");
        materialsTextField.setText("Bricks, Concrete, Wood");
        break;
      case ("Commercial"):
        typeLabel.setText(type);
        eBudgetTextField.setText("600 000");
        eManHoursTextField.setText("30 000");
        materialsTextField.setText("Bricks, Concrete, Wood, Steel");
        break;
      case ("Industrial"):
        typeLabel.setText(type);
        eBudgetTextField.setText("800 000");
        eManHoursTextField.setText("60 000");
        materialsTextField.setText("Bricks, Concrete, Wood, Steel");
        break;
      case ("Road"):
        typeLabel.setText(type);
        eBudgetTextField.setText("500 000");
        eManHoursTextField.setText("30 000");
        materialsTextField.setText("Concrete, Asphalt");
        break;

    }
  }

  @FXML public void cancelButtonPressed(){
    nameTextField.clear();
    //typeLabel.clear();
    customerTextField.clear();
    eBudgetTextField.clear();
    eManHoursTextField.clear();
    sizeTextField.clear();
    materialsTextField.clear();
    detailsTextField.clear();


    viewHandler.openView("select new");
  }

//  @FXML public void createButtonPressed(){
//    new Project(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),Double.parseDouble(eBudgetTextField.getText()),);
//  }
}
