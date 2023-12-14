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

public class SelectNewProjectViewController
{
  @FXML private Label label;
  @FXML private RadioButton resButton;
  @FXML private RadioButton comButton;
  @FXML private RadioButton indButton;
  @FXML private RadioButton roadButton;

  private String typeSelected = "";

  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;
  private ProjectListViewModel ongoingViewModel;

  public SelectNewProjectViewController(){}

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

  public void getType(ActionEvent event){
    typeSelected = "";
    if (resButton.isSelected()){
      typeSelected = "Residential";
    }
    if (comButton.isSelected()){
      typeSelected = "Commercial";
    }
    if (indButton.isSelected()){
      typeSelected = "Industrial";
    }
    if (roadButton.isSelected()){
      typeSelected = "Road";
    }
  }

  
  public String getTypeSelected(){
    return typeSelected;
  }

  @FXML public void cancelButtonPressed(){
    viewHandler.openView("projects");
  }

  @FXML public void okButtonPressed(){
    if (typeSelected.equals("")){
      label.setText("Select type!");
    }
    else{
      viewHandler.openView("new");
    }
  }

}
