package view;
import javafx.collections.*;
import model.*;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectListViewModel
{
  private ObservableList<ProjectViewModel> list;
  private ConstructionCompanyModel model;
  private boolean displayArchivedData;
  private ObservableList<ProjectViewModel> newList;

  public ProjectListViewModel(ConstructionCompanyModel model, boolean displayArchivedData){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.newList = FXCollections.observableArrayList();
    this.displayArchivedData = displayArchivedData;

    update();
  }

  public ObservableList<ProjectViewModel> getList(){
    return list;
  }

  public ObservableList<ProjectViewModel> getList(String input){
    updateNewList();
    switch (input){
      case "Any":
        newList.addAll(list);
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

      case "Date (asc.)":
        newList.addAll(list);
        int i, j;
        ProjectViewModel temp;
        int n = newList.size();
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
          swapped = false;

          for (j = 0; j < n - i - 1; j++)
          {

            if (newList.get(j).dateComparatorAscending(newList.get(j).getStartDateProperty(),
                newList.get(j + 1).getStartDateProperty()))
            {
              temp = newList.get(j);
              newList.set(j, newList.get(j + 1));
              newList.set(j + 1, temp);
              swapped = true;
            }
          }
          if (!swapped)
            break;
        }
        break;
      case "Date (desc.)":
        newList.addAll(list);
        int k, l;
        ProjectViewModel temp2;
        int n2 = newList.size();
        boolean swapped2;
        for (k = 0; k < n2 - 1; k++)
        {
          swapped2 = false;

          for (l = 0; l < n2 - k - 1; l++)
          {

            if (newList.get(l).dateComparatorDescending(newList.get(l).getStartDateProperty(),
                newList.get(l + 1).getStartDateProperty()))
            {
              temp2 = newList.get(l);
              newList.set(l, newList.get(l + 1));
              newList.set(l + 1, temp2);
              swapped2 = true;
            }
          }
          if (!swapped2)
            break;
        }
        break;
      case "Alphabetically (asc.)":
        newList.addAll(list);
        int a, b;
        ProjectViewModel temp3;
        int n3 = newList.size();
        boolean swapped3;
        for (a = 0; a < n3 - 1; a++)
        {
          swapped3 = false;

          for (b = 0; b < n3 - a - 1; b++)
          {

            if (newList.get(b).getTitleProperty().get().compareTo(newList.get(b+1).getTitleProperty().get())>0)
            {
              temp3 = newList.get(b);
              newList.set(b, newList.get(b + 1));
              newList.set(b + 1, temp3);
              swapped3 = true;
            }
          }
          if (!swapped3)
            break;
        }
        break;
      case "Alphabetically (desc.)":
        newList.addAll(list);
        int c, d;
        ProjectViewModel temp4;
        int n4 = newList.size();
        boolean swapped4;
        for (c = 0; c < n4 - 1; c++)
        {
          swapped4 = false;

          for (d = 0; d < n4 - c - 1; d++)
          {

            if (newList.get(d).getTitleProperty().get().compareTo(newList.get(d+1).getTitleProperty().get())<0)
            {
              temp4 = newList.get(d);
              newList.set(d, newList.get(d + 1));
              newList.set(d + 1, temp4);
              swapped4 = true;
            }
          }
          if (!swapped4)
            break;
        }
        break;

      }
    return newList;
  }


  public ObservableList<ProjectViewModel> getProjectListByTitle(String title){
    if (title.equals("")){
      return list;
    }
    updateNewList();
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getTitleProperty().get().toLowerCase().contains(title.toLowerCase())){
        newList.add(list.get(i));
      }
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

  public void updateNewList(){
    newList.clear();
//    for (int i = 0; i < list.size(); i++)
//    {
//      newList.add(list.get(i));
//    }
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
