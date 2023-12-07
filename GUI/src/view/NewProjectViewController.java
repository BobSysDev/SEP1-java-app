package view;
import javafx.fxml.FXML;
import javafx.scene.SnapshotResult;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.event.ActionEvent;

import java.security.PrivilegedAction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class NewProjectViewController
{
  //tabs
  @FXML private Tab projectTab;
  @FXML private Tab customerTab;
  @FXML private Tab residentialTab;
  @FXML private Tab roadTab;

  //project tab
  @FXML private TextField nameTextField;
  @FXML private Label typeLabel;
  @FXML private TextField eBudgetTextField;
  @FXML private TextField eManHoursTextField;
  @FXML private TextField eTimeIntervalTextField;
  @FXML private DatePicker startDatePicker;
  @FXML private TextField sizeTextField;
  @FXML private TextField materialsTextField;
  @FXML private TextArea detailsTextArea;

  //customer tab
  @FXML private RadioButton personRadioButton;
  @FXML private RadioButton companyRadioButton;
  @FXML private TextField firstNameTextField;
  @FXML private TextField middleNameTextField;
  @FXML private TextField lastNameTextField;
  @FXML private TextField countryCodeTextField;
  @FXML private TextField phoneNumberTextField;
  @FXML private TextField userTextField;
  @FXML private TextField hostTextField;
  @FXML private TextField domainTextField;
  @FXML private TextField companyNameTextField;
  @FXML private TextField cvrTextField;
  @FXML private Text companyNameText;
  @FXML private Text cvrText;


  //residential tab
  @FXML private TextField kitchensTextField;
  @FXML private TextField bathroomsTextField;
  @FXML private TextField plumbingTextField;
  @FXML private RadioButton yesRadioButton;
  @FXML private RadioButton noRadioButton;

  //road tab
  @FXML private TextField lengthTextField;
  @FXML private TextField widthTextField;
  @FXML private TextField bridgesTextField;
  @FXML private TextField obstaclesTextField;



  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;
  private ProjectListViewModel ongoingViewModel;
  //initialize formatted date
  private String formattedStartDate = "";
  //customer initialize
  Customer customer;


  public NewProjectViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler)
  {
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
  }

  public void reset(){
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

  public void setDefaults(String type){
    switch (type){
      case ("Residential"):
        typeLabel.setText(type);
        eBudgetTextField.setText("400000");
        eManHoursTextField.setText("20000");
        materialsTextField.setText("Bricks, Concrete, Wood");
        break;
      case ("Commercial"):
        typeLabel.setText(type);
        eBudgetTextField.setText("600000");
        eManHoursTextField.setText("30000");
        materialsTextField.setText("Bricks, Concrete, Wood, Steel");
        break;
      case ("Industrial"):
        typeLabel.setText(type);
        eBudgetTextField.setText("800000");
        eManHoursTextField.setText("60 000");
        materialsTextField.setText("Bricks, Concrete, Wood, Steel");
        break;
      case ("Road"):
        typeLabel.setText(type);
        eBudgetTextField.setText("500000");
        eManHoursTextField.setText("30000");
        materialsTextField.setText("Concrete, Asphalt");
        break;

    }
  }

  public void tabAppearance(String type){
    switch (type){
      case ("Residential"):
        roadTab.getTabPane().getTabs().remove(roadTab);
        break;
      case ("Commercial"), ("Industrial"):
        roadTab.getTabPane().getTabs().remove(roadTab);
        residentialTab.getTabPane().getTabs().remove(residentialTab);
        break;
      case ("Road"):
        residentialTab.getTabPane().getTabs().remove(residentialTab);
        break;

    }

  }
  public void isCompany(ActionEvent event){
    if (personRadioButton.isSelected()){
      companyNameTextField.setVisible(false);
      companyNameText.setVisible(false);
      cvrTextField.setVisible(false);
      cvrText.setVisible(false);
    }
    if (companyRadioButton.isSelected()){
      companyNameTextField.setVisible(true);
      companyNameText.setVisible(true);
      cvrTextField.setVisible(true);
      cvrText.setVisible(true);
    }
  }

  public boolean isNewBuild(){
    if (yesRadioButton.isSelected()){
      return true;
    }
    else {
      return false;
    }
  }

  public void setupDate(ActionEvent event){
    LocalDate startDate = startDatePicker.getValue();
    formattedStartDate = startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
  }

  public String getFormattedStartDate(){
    return formattedStartDate;
  }

  public String getProjectType(){
    switch (typeLabel.getText()){
      case ("Residential"):
        return "Residential";
      case ("Commercial"):
        return "Commercial";
      case ("Industrial"):
        return "Industrial";
      case ("Road"):
        return "Road";
    }
    return null;
  }

  @FXML public void cancelButtonPressed(){
    nameTextField.clear();
    //typeLabel.clear();
    eBudgetTextField.clear();
    eManHoursTextField.clear();
    sizeTextField.clear();
    materialsTextField.clear();
    //detailsTextField.clear();


    viewHandler.openView("select new");
  }

  @FXML public void createButtonPressed(){
    //name create
    Name name;
    if(middleNameTextField.getText().isEmpty()){
      name = new Name(firstNameTextField.getText(),lastNameTextField.getText());
    }
    else {
      name = new Name(firstNameTextField.getText(), middleNameTextField.getText(), lastNameTextField.getText());
    }

    //phone create
    Phone phone = new Phone(countryCodeTextField.getText(), phoneNumberTextField.getText());

    //email create
    Email email = new Email(userTextField.getText(), hostTextField.getText(), domainTextField.getText());


    //customer create
    if (personRadioButton.isSelected()){
      customer = new Customer(name, phone, email);
    }
    else if (companyRadioButton.isSelected()) {
      CustomerCompany company = new CustomerCompany(companyNameTextField.getText(),cvrTextField.getText());
      customer = new Customer(name, phone, email, company);

    }

    switch (typeLabel.getText()){
      case ("Residential"):
        Project resProject = new ResidentialProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
            Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
            Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
            Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
            materialsTextField.getText(),Double.parseDouble(sizeTextField.getText()),
            Integer.parseInt(kitchensTextField.getText()), Integer.parseInt(bathroomsTextField.getText()),
            Integer.parseInt(plumbingTextField.getText()),isNewBuild(),getFormattedStartDate(),customer);
        model.addProject(resProject);
        break;
      case ("Commercial"):
        Project comProject = new CommercialProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
            Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
            Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
            Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
            materialsTextField.getText(),Double.parseDouble(sizeTextField.getText()),useTextField.getText(),getFormattedStartDate(),customer);
        model.addProject(comProject);
        break;
      case ("Industrial"):
        Project indProject = new IndustrialProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
            Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
            Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
            Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
            materialsTextField.getText(),Double.parseDouble(sizeTextField.getText()),typeLabel.getText(),getFormattedStartDate(),customer);
        model.addProject(indProject);
        break;
      case ("Road"):
        Project roadProject = new RoadConstructionProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
            Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
            Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
            Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
            materialsTextField.getText(),Double.parseDouble(lengthTextField.getText()),Double.parseDouble(widthTextField.getText()),
            Integer.parseInt(obstaclesTextField.getText()),obstaclesTextField.getText(),typeLabel.getText(),getFormattedStartDate(),customer);
        break;
    }
    viewHandler.openView("projects");
  }
}