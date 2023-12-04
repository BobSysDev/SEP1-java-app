package view;

import model.Customer;
import model.MyDate;
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

}
