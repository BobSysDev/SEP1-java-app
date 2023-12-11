package view;
import javafx.collections.*;
import model.*;
public class ProjectListViewModel
{
  private ObservableList<ProjectViewModel> list;
  private ConstructionCompanyModel model;
  private boolean displayArchivedData;

  public ProjectListViewModel(ConstructionCompanyModel model, boolean displayArchivedData){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.displayArchivedData = displayArchivedData;
    update();
  }

  public ObservableList<ProjectViewModel> getList(){
    return list;
  }

  public ObservableList<ProjectViewModel> getList(String type){
    ObservableList<ProjectViewModel> newList = FXCollections.observableArrayList();
    switch (type){
      case "Any":
        newList = list;
        break;
      case "Residential":
        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getTypeProperty().get().equals("Residential")){
            newList.add(list.get(i));
          }
        }
        break;
      case "Commercial":
        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getTypeProperty().get().equals("Commercial")){
            newList.add(list.get(i));
          }
        }
        break;
      case "Industrial":
        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getTypeProperty().get().equals("Industrial")){
            newList.add(list.get(i));
          }
        }
        break;
      case "Road":
        for (int i = 0; i < list.size(); i++) {
          if (list.get(i).getTypeProperty().get().equals("Road")){
            newList.add(list.get(i));
          }
        }
        break;

    }
    return newList;
  }

  public void update(){
    list.clear();
    for (int i = 0; i < model.listSize(); i++)
    {
      if(model.getProject(i).isArchived() == displayArchivedData){
        list.add(new ProjectViewModel(model.getProject(i)));
      }
    }
  }

  public void add(Project project){
    list.add(new ProjectViewModel(project));
  }

  public void remove(Project project){
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getProjectIDProperty().get() == (project.getProjectID())){
        list.remove(i);
        break;
      }
    }
  }
}
