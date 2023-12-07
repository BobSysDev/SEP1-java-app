package view;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import model.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


import java.util.Optional;

public class DetailsViewController
{
  //header
  @FXML private Label headerTypeLabel;
  @FXML private Label headerNameLabel;

  //1st section
  @FXML private Label typeLabel;
  @FXML private Label nameLabel;
  @FXML private Label clientLabel;
  @FXML private Label idLabel;
  @FXML private Label startDateLabel;
  @FXML private Label durationLabel;

  //materials
  @FXML private Label materialsLabel;

  //table
  @FXML private Label eManHoursLabel;
  @FXML private Label eBudgetLabel;
  @FXML private Label aManHoursLabel;
  @FXML private Label aBudgetLabel;

  //properties
  @FXML private Label bathroomsLabel;
  @FXML private Label kitchensLabel;
  @FXML private Label plumbingLabel;
  @FXML private Label sizeLabel;
  @FXML private Label newBuildLabel;

  //details
  @FXML private Label detailsLabel;


  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;
  private ProjectListViewModel ongoingViewModel;

  public DetailsViewController(){}

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

  @FXML public void archiveButtonPressed(){}
  @FXML public void editButtonPressed(){}
  @FXML public void deleteButtonPressed(){}


}
