package view;

import model.Project;

import javafx.beans.property.*;

import javax.print.DocFlavor;

public class ProjectViewModel
{
  private StringProperty typeProperty;
  private StringProperty titleProperty;
  private DoubleProperty budgetProperty;
  private DoubleProperty budgetEstimateProperty;
  private IntegerProperty timeIntervalProperty;
  private IntegerProperty timeEstimateProperty;
  private DoubleProperty manHoursProperty;
  private DoubleProperty manHoursEstimateProperty;
  private IntegerProperty projectIDProperty;
  private BooleanProperty isArchivedProperty;
  private StringProperty detailsProperty;
  private StringProperty materialsProperty;
  private StringProperty customerNameProperty;
  private StringProperty startDateProperty;

  public ProjectViewModel(Project project)
  {
    typeProperty = new SimpleStringProperty(project.getType());
    titleProperty = new SimpleStringProperty(project.getTitle());
    budgetProperty = new SimpleDoubleProperty(project.getBudget());
    budgetEstimateProperty = new SimpleDoubleProperty(project.getBudgetEstimate());
    timeIntervalProperty = new SimpleIntegerProperty(project.getTimeInterval());
    timeEstimateProperty= new SimpleIntegerProperty(project.getTimeEstimate());
    manHoursProperty = new SimpleDoubleProperty(project.getManHours());
    manHoursEstimateProperty = new SimpleDoubleProperty(project.getManHoursEstimate());
    projectIDProperty = new SimpleIntegerProperty(project.getProjectID());
    isArchivedProperty = new SimpleBooleanProperty(project.isArchived());
    detailsProperty = new SimpleStringProperty(project.getDetails());
    materialsProperty = new SimpleStringProperty(project.getMaterials());
    customerNameProperty = new SimpleStringProperty(project.getCustomer().getName().getFullName());
    startDateProperty = new SimpleStringProperty(project.getStartDate());

  }

  public StringProperty getTypeProperty() {
    return typeProperty;
  }
  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }
  public DoubleProperty getBudgetProperty()
  {
    return budgetProperty;
  }
  public DoubleProperty getBudgetEstimateProperty()
  {
    return budgetEstimateProperty;
  }
  public IntegerProperty getTimeIntervalProperty()
  {
    return timeIntervalProperty;
  }
  public IntegerProperty getTimeEstimateProperty()
  {
    return timeEstimateProperty;
  }
  public DoubleProperty getManHoursProperty()
  {
    return manHoursProperty;
  }
  public DoubleProperty getManHoursEstimateProperty()
  {
    return manHoursEstimateProperty;
  }
  public IntegerProperty getProjectIDProperty()
  {
    return projectIDProperty;
  }
  public BooleanProperty getIsArchivedProperty()
  {
    return isArchivedProperty;
  }
  public StringProperty getDetailsProperty()
  {
    return detailsProperty;
  }
  public StringProperty getMaterialsProperty()
  {
    return materialsProperty;
  }
  public StringProperty getCustomerNameProperty()
  {
    return customerNameProperty;
  }
  public StringProperty getStartDateProperty(){
    return startDateProperty;
  }

  public boolean dateComparatorAscending( StringProperty spdate1, StringProperty spdate2){
    String stringDate1 = spdate1.get();
    String stringDate2 = spdate2.get();

    int[] date1 = new int[3];
    int[] date2 = new int[3];
    int i = 0;
    for(String num : stringDate1.split("\\.")){
      date1[i] = Integer.parseInt(num);
      i++;
    }

    i = 0;
    for(String num : stringDate2.split("\\.")){
      date2[i] = Integer.parseInt(num);
      i++;
    }
    if (date1[2]>date2[2]){
      return true;
    }
    else if (date1[2]<date2[2]) {
      return false;
    }
    else {
      if (date1[1]>date2[1]){
        return true;
      }
      else if (date1[1]<date2[1]) {
        return false;
      }
      else {
        if (date1[0]>date2[0]){
          return true;
        }
        else if (date1[0]<date2[0]) {
          return false;
        }
        else {
          return false;
        }
      }
    }

  }

  public boolean dateComparatorDescending(StringProperty spdate1, StringProperty spdate2){
    String stringDate1 = spdate1.get();
    String stringDate2 = spdate2.get();

    int[] date1 = new int[3];
    int[] date2 = new int[3];
    int i = 0;
    for(String num : stringDate1.split("\\.")){
      date1[i] = Integer.parseInt(num);
      i++;
    }

    i = 0;
    for(String num : stringDate2.split("\\.")){
      date2[i] = Integer.parseInt(num);
      i++;
    }
    if (date1[2]>date2[2]){
      return false;
    }
    else if (date1[2]<date2[2]) {
      return true;
    }
    else {
      if (date1[1]>date2[1]){
        return false;
      }
      else if (date1[1]<date2[1]) {
        return true;
      }
      else {
        if (date1[0]>date2[0]){
          return false;
        }
        else if (date1[0]<date2[0]) {
          return true;
        }
        else {
          return true;
        }
      }
    }

  }

}
