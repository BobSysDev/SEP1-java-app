package view;
import javafx.fxml.FXML;
import javafx.scene.SnapshotResult;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import model.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.PrivilegedAction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class NewProjectViewController
{
  //tabs
  @FXML private Tab projectTab;
  @FXML private Tab customerTab;
  @FXML private Tab residentialTab;
  @FXML private Tab commercialTab;
  @FXML private Tab industrialTab;
  @FXML private Tab roadTab;

  //project tab
  @FXML private TextField nameTextField;
  @FXML private Label typeLabel;
  @FXML private TextField eBudgetTextField;
  @FXML private TextField eManHoursTextField;
  @FXML private TextField eTimeIntervalTextField;
  @FXML private DatePicker startDatePicker;
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
  @FXML private TextField resPlumbingTextField;
  @FXML private TextField resSizeTextField;
  @FXML private RadioButton yesRadioButton;
  @FXML private RadioButton noRadioButton;

  //commercial tab
  @FXML private TextField comUseTextField;
  @FXML private TextField comFloorsTextField;
  @FXML private TextField comSizeTextField;

  //road tab
  @FXML private TextField lengthTextField;
  @FXML private TextField widthTextField;
  @FXML private TextField bridgesTextField;
  @FXML private TextField obstaclesTextField;

  //industrial tab
  @FXML private TextField indUseTextField;
  @FXML private TextField indSizeTextField;

  @FXML private Label errorLabel;

  @FXML private Text imagePathLabel;

  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;
  private SelectNewProjectViewController selectNewProjectViewController;
  private ProjectListViewModel ongoingViewModel;
  //initialize formatted date
  private String formattedStartDate = "";
  private String finalPhotoPath = "";

  //customer initialize
  Customer customer;


  public NewProjectViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler)
  {
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;



//    setDefaults(selectNewProjectViewController.getTypeSelected());
//    tabAppearance(selectNewProjectViewController.getTypeSelected());
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
        eBudgetTextField.setText("300000");
        eTimeIntervalTextField.setText("9");
        kitchensTextField.setText("1");
        bathroomsTextField.setText("1");
        resPlumbingTextField.setText("1");
        materialsTextField.setText("Bricks, Concrete, Wood");
        personRadioButton.setSelected(true);
        companyNameTextField.setVisible(false);
        companyNameText.setVisible(false);
        cvrTextField.setVisible(false);
        cvrText.setVisible(false);

        break;
      case ("Commercial"):
        typeLabel.setText(type);
        eBudgetTextField.setText("1250000");
        eTimeIntervalTextField.setText("18");
        comFloorsTextField.setText("1");
        materialsTextField.setText("Bricks, Concrete, Wood, Steel");
        companyRadioButton.setSelected(true);
        break;
      case ("Industrial"):
        typeLabel.setText(type);
        eBudgetTextField.setText("6000000");
        eTimeIntervalTextField.setText("30");
        materialsTextField.setText("Bricks, Concrete, Wood, Steel");
        companyRadioButton.setSelected(true);
        break;
      case ("Road"):
        typeLabel.setText(type);
        eBudgetTextField.setText("3000000");
        eTimeIntervalTextField.setText("18");
        bridgesTextField.setText("0");
        obstaclesTextField.setText("none");
        materialsTextField.setText("Concrete, Asphalt");
        companyRadioButton.setSelected(true);
        break;

    }
  }

  public void tabAppearance(String type){
    switch (type){
      case ("Residential"):
        roadTab.getTabPane().getTabs().remove(roadTab);
        commercialTab.getTabPane().getTabs().remove(commercialTab);
        industrialTab.getTabPane().getTabs().remove(industrialTab);

        break;
      case ("Commercial"):
        roadTab.getTabPane().getTabs().remove(roadTab);
        residentialTab.getTabPane().getTabs().remove(residentialTab);
        industrialTab.getTabPane().getTabs().remove(industrialTab);
        break;
      case ("Industrial"):
        residentialTab.getTabPane().getTabs().remove(residentialTab);
        roadTab.getTabPane().getTabs().remove(roadTab);
        commercialTab.getTabPane().getTabs().remove(commercialTab);
        break;
      case ("Road"):
        residentialTab.getTabPane().getTabs().remove(residentialTab);
        commercialTab.getTabPane().getTabs().remove(commercialTab);
        industrialTab.getTabPane().getTabs().remove(industrialTab);
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

  @FXML public void uploadButtonPressed(){
    String pathToCopyTo = model.getPathForWebsiteRoot() + "/images";
    System.out.println(pathToCopyTo);
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select a cover photo for this project");
    fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
    File selectedFile = fileChooser.showOpenDialog(null);
    try
    {
      Files.copy(selectedFile.toPath(), new File(pathToCopyTo + "/" + selectedFile.getName()).toPath());


      finalPhotoPath = "images/" + selectedFile.getName();
      imagePathLabel.setText(finalPhotoPath);
    }
    catch (IOException e){
      errorLabel.setText("There was a problem copying the photo. Please try again.");
    }
    catch (NullPointerException e2){
      errorLabel.setText("You didn't select a photo. Please try again.");
    }
  }

  @FXML public void cancelButtonPressed(){
    nameTextField.clear();
    //typeLabel.clear();
    eBudgetTextField.clear();
    eManHoursTextField.clear();
    //sizeTextField.clear();
    materialsTextField.clear();
    //detailsTextField.clear();


    viewHandler.openView("select new");
  }

  @FXML public void createButtonPressed(){
    try
    {
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
      else {
        throw new Exception("Please select person or company.");
      }

      switch (typeLabel.getText()){
        case ("Residential"):
          Project resProject = new ResidentialProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
              Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
              Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
              Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
              materialsTextField.getText(),Double.parseDouble(resSizeTextField.getText()),
              Integer.parseInt(kitchensTextField.getText()), Integer.parseInt(bathroomsTextField.getText()),
              Integer.parseInt(resPlumbingTextField.getText()),isNewBuild(),getFormattedStartDate(),customer);
          resProject.setPhotoPathForWebsite(finalPhotoPath);
          model.addProject(resProject);
          break;
        case ("Commercial"):
          Project comProject = new CommercialProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
              Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
              Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
              Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
              materialsTextField.getText(),Double.parseDouble(comSizeTextField.getText()),comUseTextField.getText(),
              Integer.parseInt(comFloorsTextField.getText()), getFormattedStartDate(),customer);
          comProject.setPhotoPathForWebsite(finalPhotoPath);
          model.addProject(comProject);
          break;
        case ("Industrial"):
          Project indProject = new IndustrialProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
              Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
              Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
              Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
              materialsTextField.getText(),Double.parseDouble(indSizeTextField.getText()),indUseTextField.getText(),getFormattedStartDate(),customer);
          indProject.setPhotoPathForWebsite(finalPhotoPath);
          model.addProject(indProject);
          break;
        case ("Road"):
          Project roadProject = new RoadConstructionProject(nameTextField.getText(),Double.parseDouble(eBudgetTextField.getText()),
              Double.parseDouble(eBudgetTextField.getText()),Integer.parseInt(eTimeIntervalTextField.getText()),
              Integer.parseInt(eTimeIntervalTextField.getText()),Double.parseDouble(eManHoursTextField.getText()),
              Double.parseDouble(eManHoursTextField.getText()), model.listSize(), false, detailsTextArea.getText(),
              materialsTextField.getText(),Double.parseDouble(lengthTextField.getText()),Double.parseDouble(widthTextField.getText()),
              Integer.parseInt(bridgesTextField.getText()),obstaclesTextField.getText(),getFormattedStartDate(),customer);
          roadProject.setPhotoPathForWebsite(finalPhotoPath);
          model.addProject(roadProject);
          break;
      }
      model.writeProjectsToBinaryFile();
      viewHandler.openView("projects");

    }
    catch (RuntimeException e){
      errorLabel.setText("Something went wrong! Fill out every window or check details you have entered.");
    }
    catch (Exception e){
      errorLabel.setText(e.getMessage());
    }
  }
}
