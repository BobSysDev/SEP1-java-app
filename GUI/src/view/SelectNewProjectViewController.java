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

/**
 * The class SelectNewProjectViewController is the controller of select new type of project window.
 *
 * @author Samuel Knieza
 * @version 1.0 - December 2023
 */
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

  /**
   * Zero argument constructor representing this window controller class.
   */
  public SelectNewProjectViewController(){}


  /**
   * Initializing method ran everytime when the window is launched.
   *
   * @param root
   *      root
   * @param model
   *      interface with methods used for project manipulation
   * @param viewHandler
   *      class handling which window is showing
   */
  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler)
  {
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
  }

  /**
   * Resets project list, clearing it and then assigning all projects back
   */
  public void reset(){
    viewModel.update();
  }

  /**
   * A getter for root
   *
   * @return root
   */
  public Region getRoot(){
    return root;
  }

  /**
   * A getter for project type sourced from radio buttons.
   *
   * @param event
   *      radio button selected
   */
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


  /**
   * A getter for selected type.
   *
   * @return typeSelected
   */
  public String getTypeSelected(){
    return typeSelected;
  }

  /**
   * Going back to main projectView window after cancel button is pressed.
   */
  @FXML public void cancelButtonPressed(){
    viewHandler.openView("projects");
  }


  /**
   * Opens a new window for creation of a new project (NewProjectView)
   * If user selects no type warning will show.
   */
  @FXML public void okButtonPressed(){
    if (typeSelected.equals("")){
      label.setText("Select type!");
    }
    else{
      viewHandler.openView("new");
    }
  }

}
