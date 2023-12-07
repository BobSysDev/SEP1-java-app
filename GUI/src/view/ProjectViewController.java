package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import model.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.event.Event;
import java.util.Optional;

public class ProjectViewController
{
  @FXML private TabPane tabPane;
  @FXML private Tab ongoingTab;

  @FXML private TableView<ProjectViewModel> projectListTable;
  @FXML private TableColumn<ProjectViewModel, String> typeColumn;
  @FXML private TableColumn<ProjectViewModel, String> nameColumn;
  @FXML private TableColumn<ProjectViewModel, String> dateColumn;

  @FXML private TableView<ProjectViewModel> ongoingProjectListTable;
  @FXML private TableColumn<ProjectViewModel, String> ongoingTypeColumn;
  @FXML private TableColumn<ProjectViewModel, String> ongoingNameColumn;
  @FXML private TableColumn<ProjectViewModel, String> ongoingDateColumn;

  @FXML private Button detailsButton;
  @FXML private Label errorLabel;

  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;
  private ProjectListViewModel ongoingViewModel;

  public ProjectViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler){
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
    this.viewModel = new ProjectListViewModel(model, true);
    this.ongoingViewModel = new ProjectListViewModel(model, false);


    typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    dateColumn.setCellValueFactory(cellData -> cellData.getValue().getStartDateProperty());

    ongoingTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
    ongoingNameColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    ongoingDateColumn.setCellValueFactory(cellData -> cellData.getValue().getStartDateProperty());


    projectListTable.setItems(viewModel.getList());
    ongoingProjectListTable.setItems(ongoingViewModel.getList());
  }

  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

  public void selectDefaultTab(){
    tabPane.getSelectionModel().select(ongoingTab);
  }

  @FXML public void newProjectButtonPressed(){
    viewHandler.openView("select new");
  }

  @FXML public void exportProjectsToXMLButtonPressed(){
    model.writeProjectsToXMLFile();
  }

  @FXML public void detailsButtonPressed(){
    viewHandler.openView("details");
  }

  @FXML public void filterButtonPressed(){
    detailsButton.setDisable(false);
  }
//  @Override public void handle(ActionEvent event)
//  {
//  }
}
