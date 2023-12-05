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

public class ProjectViewController
{

  @FXML private TableView<ProjectViewModel> projectListTable;
  @FXML private TableColumn<ProjectViewModel, String> typeColumn;
  @FXML private TableColumn<ProjectViewModel, String> nameColumn;
  @FXML private TableColumn<ProjectViewModel, String> dateColumn;
  @FXML private Label errorLabel;

  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;

  public ProjectViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler){
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
    this.viewModel = new ProjectListViewModel(model);

    typeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
    dateColumn.setCellValueFactory(cellData -> cellData.getValue().getStartDateProperty());


    projectListTable.setItems(viewModel.getList());
  }

  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

  @FXML public void newProjectButtonPressed(){
    viewHandler.openView("select new");
  }



}
