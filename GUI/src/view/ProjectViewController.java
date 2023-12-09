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
  @FXML private Tab pastTab;
  @FXML private Tab settingsTab;

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

    //enabling the details button in past projects table
    TableSelectionModel<ProjectViewModel> selectionModel = projectListTable.getSelectionModel();
    selectionModel.selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if (newSelection != null) {
        detailsButton.setDisable(false);
        System.out.println(getProjectID(getSelectedTab()));
      } else {
        detailsButton.setDisable(true);
      }
    });

    //enabling the details button in ongoing projects table
    TableSelectionModel<ProjectViewModel> selectionModel2 = ongoingProjectListTable.getSelectionModel();
    selectionModel2.selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if (newSelection != null) {
        detailsButton.setDisable(false);
        System.out.println(getProjectID(getSelectedTab()));
      }
      else {
        detailsButton.setDisable(true);
      }
    });

  }

  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

//  public ProjectViewModel getProjectByID(int id){
//    return model.getProject(id - 1);
//  }
  public void selectDefaultTab(){
    tabPane.getSelectionModel().select(ongoingTab);
  }

  public int getSelectedTab(){
    int n = -1;
    if (ongoingTab.isSelected()){
      n = 0;
    }
    else if (pastTab.isSelected()) {
      n = 1;
    }
    else if (settingsTab.isSelected()){
      n = 3;
    }
    return n;
  }

  public int getProjectID(int tab){
    int id = -1;
    switch (tab){
      case 0:
        TableSelectionModel<ProjectViewModel> ongoingSelectionModel = ongoingProjectListTable.getSelectionModel();
        ProjectViewModel ongoingSelectedData = ongoingSelectionModel.getSelectedItem();
        id = ongoingSelectedData.getProjectIDProperty().get();
        break;
      case 1:
        TableSelectionModel<ProjectViewModel> pastSelectionModel = projectListTable.getSelectionModel();
        ProjectViewModel pastSelectedData = pastSelectionModel.getSelectedItem();
        id = pastSelectedData.getProjectIDProperty().get();
        break;
    }
    return id;
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
}
