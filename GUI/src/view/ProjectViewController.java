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
  @FXML private TableColumn<ProjectViewModel, MyDate> dateColumn;
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
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty()));
    //dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDa);


    projectListTable.setItems(viewModel.getList());
  }

  public void reset(){
    errorLabel.setText("");
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

  @FXML public void addGradeButtonPressed(){
    viewHandler.openView("add");
  }

  @FXML public void showGradeDetailsButtonPressed(){
    viewHandler.openView("details");
  }

  @FXML public void removeGradeButtonPressed(){
    errorLabel.setText("");
    try{
      GradeViewModel selectedItem = gradeListTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if (remove){
        Grade grade = new Grade(selectedItem.getGradeProperty().get(),selectedItem.getCourseProperty().get());
        model.removeGrade(grade);
        viewModel.remove(grade);
        gradeListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e){
      errorLabel.setText("Item not found: "+e.getMessage());
    }
  }

  private boolean confirmation(){
    int index = gradeListTable.getSelectionModel().getSelectedIndex();
    GradeViewModel selectedItem = gradeListTable.getItems().get(index);
    if (index<0 || index>=gradeListTable.getItems().size()){
      return false;
    }
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing grade{"+selectedItem.getCourseProperty()+" : "+selectedItem.getGradeProperty()+"}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent())&&(result.get()==ButtonType.OK);
  }

}
