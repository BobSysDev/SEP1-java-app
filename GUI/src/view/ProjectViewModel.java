package view;

import model.Project;

import javafx.beans.property.*;

import javax.print.DocFlavor;

/**
 * The class ProjectViewModel is for initializing and "converting"
 * project's information to format which can be used by JavaFX
 *
 * @author Samuel Knieza
 * @version 1.0 - December 2023
 */
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


  /**
   * One argument constructor initiating all property-like variables,
   * sourcing from project inputted.
   *
   * @param project
   *      project
   */
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

  /**
   * A getter method for type property string.
   *
   * @return typeProperty
   */
  public StringProperty getTypeProperty() {
    return typeProperty;
  }

  /**
   * A getter method for title property string.
   *
   * @return titleProperty
   */
  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  /**
   * A getter method for budget property double.
   *
   * @return budgetProperty
   */
  public DoubleProperty getBudgetProperty()
  {
    return budgetProperty;
  }

  /**
   * A getter method for budget estimate property double.
   *
   * @return budgetEstimateProperty
   */
  public DoubleProperty getBudgetEstimateProperty()
  {
    return budgetEstimateProperty;
  }

  /**
   * A getter method for time interval property integer.
   *
   * @return timeIntervalProperty
   */
  public IntegerProperty getTimeIntervalProperty()
  {
    return timeIntervalProperty;
  }

  /**
   * A getter method for time estimate property integer.
   *
   * @return timeEstimateProperty
   */
  public IntegerProperty getTimeEstimateProperty()
  {
    return timeEstimateProperty;
  }

  /**
   * A getter method for man-hours property double.
   *
   * @return manHoursProperty
   */
  public DoubleProperty getManHoursProperty()
  {
    return manHoursProperty;
  }

  /**
   * A getter method for man-hours estimate property double.
   *
   * @return manHoursEstimateProperty
   */
  public DoubleProperty getManHoursEstimateProperty()
  {
    return manHoursEstimateProperty;
  }

  /**
   * A getter method for ID property integer.
   *
   * @return projectIDProperty
   */
  public IntegerProperty getProjectIDProperty()
  {
    return projectIDProperty;
  }

  /**
   * A getter method for is archived property boolean.
   *
   * @return isArchivedProperty
   */
  public BooleanProperty getIsArchivedProperty()
  {
    return isArchivedProperty;
  }

  /**
   * A getter method for details property string.
   *
   * @return detailsProperty
   */
  public StringProperty getDetailsProperty()
  {
    return detailsProperty;
  }

  /**
   * A getter method for materials property string.
   *
   * @return materialsProperty
   */
  public StringProperty getMaterialsProperty()
  {
    return materialsProperty;
  }

  /**
   * A getter method for customer property string.
   *
   * @return customerProperty
   */
  public StringProperty getCustomerNameProperty()
  {
    return customerNameProperty;
  }

  /**
   * A getter method for start date property string.
   *
   * @return startDateProperty
   */
  public StringProperty getStartDateProperty(){
    return startDateProperty;
  }

  /**
   * Compares 2 inputted dates in format dd.mm.yyyy, separating the integers to array.
   * Comparing the integers from arrays and returning true if 1st date is "bigger" (more in the future) and vice versa.
   *
   * @param spdate1
   *      String property of 1st date
   *
   * @param spdate2
   *      String property of 2nd date
   *
   * @return true or false
   */
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

  /**
   * Compares 2 inputted dates in format dd.mm.yyyy, separating the integers to array.
   * Comparing the integers from arrays and returning true if 1st date is "smaller" (more in the past) and vice versa.
   *
   * @param spdate1
   *      String property of 1st date
   *
   * @param spdate2
   *      String property of 2nd date
   *
   * @return true or false
   */
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
