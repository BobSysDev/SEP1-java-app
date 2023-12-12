package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import model.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.event.Event;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProjectViewController
{
  @FXML private TabPane tabPane;
  @FXML private Tab ongoingTab;
  @FXML private Tab pastTab;
  @FXML private Tab settingsTab;

  @FXML private TextField searchOngoingTextField;
  @FXML private TextField searchPastTextField;
  @FXML private Button enterOngoingButton;
  @FXML private Button enterPastButton;

  @FXML private ChoiceBox<String> filterOngoingChoiceBox;
  @FXML private ChoiceBox<String> filterPastChoiceBox;
  @FXML private ChoiceBox<String> sortOngoingChoiceBox;
  @FXML private ChoiceBox<String> sortPastChoiceBox;
  private String[] types = {"Any","Residential","Commercial","Industrial","Road"};
  private String[] sortings = {"Date (asc.)","Date (desc.)","Alphabetically (asc.)","Alphabetically (desc.)"};

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
  private ProjectDateComparator dateComparator;

  public ProjectViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler){
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
    this.viewModel = new ProjectListViewModel(model, true);
    this.ongoingViewModel = new ProjectListViewModel(model, false);

    //populating filter choice box
    filterOngoingChoiceBox.getItems().addAll(types);
    filterPastChoiceBox.getItems().addAll(types);
    //setting action to choice box filter
    filterOngoingChoiceBox.setOnAction(this::getFilterTypeOngoing);
    filterPastChoiceBox.setOnAction(this::getFilterTypePast);

    //populating sort choice box
    sortOngoingChoiceBox.getItems().addAll(sortings);
    sortPastChoiceBox.getItems().addAll(sortings);
    //setting action to choice box sort
    sortOngoingChoiceBox.setOnAction(this::getSortOngoing);
    sortPastChoiceBox.setOnAction(this::getSortPast);

    typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    dateColumn.setCellValueFactory(cellData -> cellData.getValue().getStartDateProperty());

    typeColumn.setSortable(false);
    nameColumn.setSortable(false);
    dateColumn.setSortable(false);

    ongoingTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
    ongoingNameColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    ongoingDateColumn.setCellValueFactory(cellData -> cellData.getValue().getStartDateProperty());

    ongoingTypeColumn.setSortable(false);
    ongoingNameColumn.setSortable(false);
    ongoingDateColumn.setSortable(false);


    projectListTable.setItems(viewModel.getList());
    ongoingProjectListTable.setItems(ongoingViewModel.getList());



    //enabling the details button in past projects table
    TableSelectionModel<ProjectViewModel> selectionModel = projectListTable.getSelectionModel();
    selectionModel.selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      if (newSelection != null) {
        detailsButton.setDisable(false);
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

//    enterOngoingButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
//      @Override
//      public void handle(KeyEvent event) {
//        if (event.getCode() == KeyCode.ENTER) {
//          enterOngoingButtonPressed();
//        }
//      }
//    });
  }

  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

  @FXML void enterOngoingButtonPressed(){
    String ongoingSearchText = searchOngoingTextField.getText();
    ongoingProjectListTable.setItems(ongoingViewModel.getProjectListByTitle(ongoingSearchText));
  }

  @FXML void enterPastButtonPressed(){
    String ongoingSearchText = searchPastTextField.getText();
    projectListTable.setItems(viewModel.getProjectListByTitle(ongoingSearchText));
  }

  public void getFilterTypeOngoing(ActionEvent event){
    String type = filterOngoingChoiceBox.getValue();
    ongoingProjectListTable.setItems(ongoingViewModel.getList(type));
  }

  public void getFilterTypePast(ActionEvent event){
    String type = filterPastChoiceBox.getValue();
    projectListTable.setItems(viewModel.getList(type));
  }

  public void getSortOngoing(ActionEvent event){
    String sorting = sortOngoingChoiceBox.getValue();
    ongoingProjectListTable.setItems(ongoingViewModel.getList(sorting));
  }

  public void getSortPast(ActionEvent event){
    String sorting = sortPastChoiceBox.getValue();
    projectListTable.setItems(viewModel.getList(sorting));
  }


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


}
