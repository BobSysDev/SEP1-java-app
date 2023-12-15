package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.DirectoryChooser;
import model.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

/**
 * The class ProjectViewController is the controller of the ProjectView main window.
 *
 * @author Samuel Knieza
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 */

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
  private TXTFileHandlerForFilePathSettings txtFileHandlerForFilePathSettings;


  /**
   * Zero argument constructor representing this window controller class.
   */
  public ProjectViewController(){}


  /**
   * Initializing method ran everytime when the window is launched.
   * Both tables with past and ongoing project are populated.
   * Choice-boxes are being populated.
   * Embedded sorting with clicking on a column header is disabled.
   * Enabling details button after clicking on a project from table.
   *
   *
   * @param root
   *      root
   * @param model
   *      interface with methods used for project manipulation
   * @param viewHandler
   *      class handling which window is showing
   */
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

    txtFileHandlerForFilePathSettings = new TXTFileHandlerForFilePathSettings();
  }

  /**
   * Resets project list, clearing it and then assigning all projects back
   */
  public void reset(){
    errorLabel.setText("");
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
   * Searching for projects in ongoing table based on users input in searchOngoingTextField after clicking on enter button.
   */
  @FXML void enterOngoingButtonPressed(){
    String ongoingSearchText = searchOngoingTextField.getText();
    ongoingProjectListTable.setItems(ongoingViewModel.getProjectListByTitle(ongoingSearchText));
  }

  /**
   * Searching for projects in past table based on users input in searchPsstTextField after clicking on enter button.
   */
  @FXML void enterPastButtonPressed(){
    String ongoingSearchText = searchPastTextField.getText();
    projectListTable.setItems(viewModel.getProjectListByTitle(ongoingSearchText));
  }

  /**
   * Filtering projects that will show in ongoing table by selected project type.
   *
   * @param event
   *      item from choice-box clicked
   */
  public void getFilterTypeOngoing(ActionEvent event){
    String type = filterOngoingChoiceBox.getValue();
    ongoingProjectListTable.setItems(ongoingViewModel.getList(type));
  }

  /**
   * Filtering projects that will show in past table by selected project type.
   *
   * @param event
   *      item from choice-box clicked
   */
  public void getFilterTypePast(ActionEvent event){
    String type = filterPastChoiceBox.getValue();
    projectListTable.setItems(viewModel.getList(type));
  }

  /**
   * Sorting projects that will show in ongoing table by selected sorting.
   *
   * @param event
   *      item from choice-box clicked
   */
  public void getSortOngoing(ActionEvent event){
    String sorting = sortOngoingChoiceBox.getValue();
    ongoingProjectListTable.setItems(ongoingViewModel.getList(sorting));
  }
  /**
   * Sorting projects that will show in past table by selected sorting.
   *
   * @param event
   *      item from choice-box clicked
   */
  public void getSortPast(ActionEvent event){
    String sorting = sortPastChoiceBox.getValue();
    projectListTable.setItems(viewModel.getList(sorting));
  }

  /**
   * After launching this window the tab with ongoing projects will select automatically.
   */
  public void selectDefaultTab(){
    tabPane.getSelectionModel().select(ongoingTab);
  }

  /**
   * This returns an int (index) of selected tab.
   *
   * @return n
   */
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

  /**
   * Getting an ID property from selected project.
   *
   * @param tab
   *      index returned from getSelectedTab() method
   *
   * @return id
   */
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

  /**
   * Opens a new window selectNewProjectView after clicking on the new project button.
   */
  @FXML public void newProjectButtonPressed(){
    viewHandler.openView("select new");
  }

  /**
   * Writing projects from .bin file to .xml (for website)
   * Informing user about the success.
   */
  @FXML public void exportProjectsToXMLButtonPressed(){
    model.writeProjectsToXMLFile();
    errorLabel.setText("Success!");
  }

  /**
   * Opens a new detailsView window after clicking on Details button.
   */
  @FXML public void detailsButtonPressed(){
    viewHandler.openView("details");
  }

  /**
   * This method allows the user to select a new root folder of the website (this means to re-select the folder, not move the website).
   */
  @FXML public void setWebsiteRootDirectory()
  {
    if(model.Confirmation("Warning", "You are about to select a new root folder\nof the website. Are you sure you\nwant to continue?\n\n (This action cannot be reversed)")){
      try{
        String path = "";
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select the root folder of your website (the one with index.html)");
        File selectedFile = directoryChooser.showDialog(null);
        path = selectedFile.getAbsolutePath();
        model.setPathForWebsiteRoot(path);
        errorLabel.setText("Success!");
      }
      catch(NullPointerException e3){
        errorLabel.setText("Error: the directory you selected is invalid. Try again...");
      }
    }
  }

  /**
   * This method calls the corresponding method in the model, which reconstructs (overwrites) the database from the XML file.
   *
   * @see ConstructionCompanyManager#reconstructDataBaseFromXML()
   */
  @FXML public void reconstructDataBaseFromXML()
  {
    if(model.Confirmation("WARNING", "This will DELETE ALL the projects in the database\n and REPLACE them with the projects from the XML file.\n Are you ABSOLUTELY sure you want to continue? \n\n (This action CANNOT be reversed)")){
      try{
        model.reconstructDataBaseFromXML();
        errorLabel.setText("Success!");
      }
      catch(IOException e){
        errorLabel.setText("Error: something went wrong. Try again...");
      }
    }

    viewModel.update();
    ongoingViewModel.update();
  }

  /**
   * This method calls the corresponding method in the model, which imports (appends) projects from the XML file.
   *
   * @see ConstructionCompanyManager#importProjectsFromXML()
   */
  @FXML public void importProjectsFromXML()
  {
    if(model.Confirmation("Warning", "This will append all projects from the later specified file\nto the file database. Are you sure you want to continue? \n\n (This action cannot be reversed)\n(duplicates will not be imported)")){
      try{
        model.importProjectsFromXML();
        errorLabel.setText("Success!");
      }
      catch(IOException e){
        errorLabel.setText("Error: something went wrong. Try again...");
      }
      catch(NullPointerException e2){
        errorLabel.setText("Error: the file you selected is invalid. Try again...");
      }
    }
    viewModel.update();
    ongoingViewModel.update();
  }
}
