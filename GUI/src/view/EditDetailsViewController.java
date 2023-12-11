package view;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


import java.util.Optional;

public class EditDetailsViewController
{

  //1st section
  @FXML private Label typeLabel;
  @FXML private TextField nameTextField;
  @FXML private Label idLabel;
  @FXML private TextField clientFTextField;
  @FXML private TextField clientMTextField;
  @FXML private TextField clientLTextField;
  @FXML private TextField phoneTextField;
  @FXML private TextField countryCodeTextField;
  @FXML private TextField emailUTextField;
  @FXML private TextField emailHTextField;
  @FXML private TextField emailDTextField;
  @FXML private TextField startDateTextField;
  @FXML private TextField durationTextField;
  @FXML private TextField companyNameTextField;
  @FXML private TextField cvrTextField;

  //materials
  @FXML private TextArea materialsTextArea;

  //table
  @FXML private TextField eManHoursTextField;
  @FXML private TextField eBudgetTextField;
  @FXML private TextField aManHoursTextField;
  @FXML private TextField aBudgetTextField;

  //properties
  @FXML private RadioButton yesRadioButton;
  @FXML private RadioButton noRadioButton;
  @FXML private HBox rButtonsHBox;
  @FXML private TextField bathroomsTextField;
  @FXML private Text bathroomsText;
  @FXML private TextField kitchensTextField;
  @FXML private Text kitchensText;
  @FXML private TextField plumbingTextField;
  @FXML private Text plumbingText;
  @FXML private TextField sizeTextField;
  @FXML private Text sizeText;
  @FXML private Text newBuildText;
  @FXML private TextField intendedUseTextField;
  @FXML private Text intendedUseText;
  @FXML private TextField floorsTextField;
  @FXML private Text floorsText;
  @FXML private TextField lengthTextField;
  @FXML private Text lengthText;
  @FXML private TextField widthTextField;
  @FXML private Text widthText;
  @FXML private TextField bridgesTextField;
  @FXML private Text bridgesText;
  @FXML private TextField obstaclesTextField;
  @FXML private Text obstaclesText;

  //details
  @FXML private TextArea detailsTextArea;


  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectViewController projectViewController;
  private ProjectListViewModel viewModel;

  public EditDetailsViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler, ProjectViewController projectViewController, ProjectListViewModel viewModel)
  {
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
    this.projectViewController = projectViewController;
    this.viewModel = viewModel;

    setProjectDetails();
  }

  public void reset(){
    viewModel.update();
  }

  public Region getRoot(){
    return root;
  }

  public void setProjectDetails(){
    //getting the selected project from projectListController window
    int id = projectViewController.getProjectID(projectViewController.getSelectedTab());
    Project project = model.getProject(id-1);


    //setting the labels to selected project properties
    nameTextField.setText(project.getTitle());
    typeLabel.setText(project.getType());
    idLabel.setText(String.valueOf(project.getProjectID()));
    clientFTextField.setText(project.getCustomer().getName().getFirstName());
    clientMTextField.setText(project.getCustomer().getName().getMiddleName());
    clientLTextField.setText(project.getCustomer().getName().getLastName());
    phoneTextField.setText(project.getCustomer().getPhone().getPhoneNumber());
    countryCodeTextField.setText(project.getCustomer().getPhone().getCountryCode());
    emailUTextField.setText(project.getCustomer().getEmail().getUser());
    emailHTextField.setText(project.getCustomer().getEmail().getHost());
    emailDTextField.setText(project.getCustomer().getEmail().getDomain());

    if (project.getCustomer().getCompany() != null){
      companyNameTextField.setText(project.getCustomer().getCompany().getName());
      cvrTextField.setText(project.getCustomer().getCompany().getCVR());
    }
    else {
      companyNameTextField.setVisible(false);
      companyNameTextField.setVisible(false);
      cvrTextField.setVisible(false);
      cvrTextField.setVisible(false);
    }

    startDateTextField.setAlignment(Pos.CENTER_RIGHT);
    durationTextField.setAlignment(Pos.CENTER_RIGHT);
    startDateTextField.setText(project.getStartDate());
    durationTextField.setText(String.valueOf(project.getTimeEstimate()));

    materialsTextArea.setText(project.getMaterials());
    eManHoursTextField.setText(String.valueOf(project.getManHoursEstimate()));
    aManHoursTextField.setText(String.valueOf(project.getManHours()));
    eBudgetTextField.setText(String.valueOf(project.getBudgetEstimate()));
    aBudgetTextField.setText(String.valueOf(project.getBudget()));
    detailsTextArea.setText(project.getDetails());

    //displaying labels depending on selected project type
    String type = project.getType();

    switch (type){
      case "Residential":
        ResidentialProject residentialProject = (ResidentialProject) project;
        bathroomsTextField.setText(String.valueOf(residentialProject.getNumberOfBathrooms()));
        kitchensTextField.setText(String.valueOf(residentialProject.getNumberOfKitchens()));
        plumbingTextField.setText(String.valueOf(residentialProject.getOtherRoomsWithPlumbing()));
        sizeTextField.setText(String.valueOf(residentialProject.getSize()));
        if (residentialProject.isNewBuild()){
          yesRadioButton.setSelected(true);
        }
        else {
          noRadioButton.setSelected(true);
        }
        intendedUseTextField.setVisible(false);
        intendedUseText.setVisible(false);
        floorsTextField.setVisible(false);
        floorsText.setVisible(false);
        lengthTextField.setVisible(false);
        lengthText.setVisible(false);
        widthTextField.setVisible(false);
        widthText.setVisible(false);
        bridgesTextField.setVisible(false);
        bridgesText.setVisible(false);
        obstaclesTextField.setVisible(false);
        obstaclesText.setVisible(false);

        break;
      case "Commercial":
        CommercialProject commercialProject = (CommercialProject) project;
        sizeTextField.setText(String.valueOf(commercialProject.getSize()));
        intendedUseTextField.setText(commercialProject.getIntendedUse());
        floorsTextField.setText(String.valueOf(commercialProject.getNumberOfFloors()));

        bathroomsTextField.setVisible(false);
        bathroomsText.setVisible(false);
        kitchensTextField.setVisible(false);
        kitchensText.setVisible(false);
        plumbingTextField.setVisible(false);
        plumbingText.setVisible(false);
        newBuildText.setVisible(false);

        rButtonsHBox.setVisible(false);
        lengthTextField.setVisible(false);
        lengthText.setVisible(false);
        widthTextField.setVisible(false);
        widthText.setVisible(false);
        bridgesTextField.setVisible(false);
        bridgesText.setVisible(false);
        obstaclesTextField.setVisible(false);
        obstaclesText.setVisible(false);

        break;
      case "Industrial":
        IndustrialProject industrialProject = (IndustrialProject) project;
        sizeTextField.setText(String.valueOf(industrialProject.getSize()));
        intendedUseTextField.setText(industrialProject.getIntendedUse());

        bathroomsTextField.setVisible(false);
        bathroomsText.setVisible(false);
        kitchensTextField.setVisible(false);
        kitchensText.setVisible(false);
        plumbingTextField.setVisible(false);
        plumbingText.setVisible(false);
        newBuildText.setVisible(false);
        floorsTextField.setVisible(false);
        floorsText.setVisible(false);

        rButtonsHBox.setVisible(false);
        lengthTextField.setVisible(false);
        lengthText.setVisible(false);
        widthTextField.setVisible(false);
        widthText.setVisible(false);
        bridgesTextField.setVisible(false);
        bridgesText.setVisible(false);
        obstaclesTextField.setVisible(false);
        obstaclesText.setVisible(false);

        break;
      case "Road":
        RoadConstructionProject roadConstructionProject = (RoadConstructionProject) project;
        lengthTextField.setText(String.valueOf(roadConstructionProject.getLength()));
        widthTextField.setText(String.valueOf(roadConstructionProject.getWidth()));
        bridgesTextField.setText(String.valueOf(roadConstructionProject.getNumberOfBridges()));
        obstaclesTextField.setText(roadConstructionProject.getObstacles());

        rButtonsHBox.setVisible(false);
        sizeText.setVisible(false);
        sizeTextField.setVisible(false);
        bathroomsTextField.setVisible(false);
        bathroomsText.setVisible(false);
        kitchensTextField.setVisible(false);
        kitchensText.setVisible(false);
        plumbingTextField.setVisible(false);
        plumbingText.setVisible(false);
        newBuildText.setVisible(false);
        floorsTextField.setVisible(false);
        floorsText.setVisible(false);
        intendedUseTextField.setVisible(false);
        intendedUseText.setVisible(false);
        break;
    }
  }

  @FXML public void discardButtonPressed(){
    viewHandler.openView("details");
  };
  @FXML public void saveButtonPressed(){
    //getting the selected project from projectListController window
    int id = projectViewController.getProjectID(projectViewController.getSelectedTab());
    Project project = model.getProject(id-1);
    String type = project.getType();

    //saving and overwriting the project with new or old information
    project.setTitle(nameTextField.getText());

    //setting name
    project.getCustomer().getName().setFirstName(clientFTextField.getText());
    project.getCustomer().getName().setMiddleName(clientMTextField.getText());
    project.getCustomer().getName().setLastName(clientLTextField.getText());

    //setting phone
    project.getCustomer().getPhone().setCountryCode(countryCodeTextField.getText());
    project.getCustomer().getPhone().setPhoneNumber(phoneTextField.getText());

    //setting email
    project.getCustomer().getEmail().setUser(emailUTextField.getText());
    project.getCustomer().getEmail().setHost(emailHTextField.getText());
    project.getCustomer().getEmail().setDomain(emailDTextField.getText());

    //setting dates
    project.setStartDate(startDateTextField.getText());
    project.setTimeEstimate(Integer.parseInt(durationTextField.getText()));

    //setting company if possible
    if (!companyNameTextField.getText().isEmpty() || !cvrTextField.getText().isEmpty()){
      project.getCustomer().getCompany().setName(companyNameTextField.getText());
      project.getCustomer().getCompany().setCVR(cvrTextField.getText());
    }

    //setting materials
    project.setMaterials(materialsTextArea.getText());

    //setting table estimate/actual
    project.setManHoursEstimate(Double.parseDouble(eManHoursTextField.getText()));
    project.setManHours(Double.parseDouble(aManHoursTextField.getText()));
    project.setBudgetEstimate(Double.parseDouble(eBudgetTextField.getText()));
    project.setBudget(Double.parseDouble(aBudgetTextField.getText()));

    //setting extra info depending on project type
    switch (type){
      case "Residential":
        ResidentialProject residentialProject = (ResidentialProject) project;
        residentialProject.setNumberOfBathrooms(Integer.parseInt(bathroomsTextField.getText()));
        residentialProject.setNumberOfKitchens(Integer.parseInt(kitchensTextField.getText()));
        residentialProject.setOtherRoomsWithPlumbing(Integer.parseInt(plumbingTextField.getText()));
        residentialProject.setSize(Double.parseDouble(sizeTextField.getText()));
        if (yesRadioButton.isSelected()){
          residentialProject.setNewBuild(true);
        }
        else {
          residentialProject.setNewBuild(false);
        }
        break;
      case "Commercial":
        CommercialProject commercialProject = (CommercialProject) project;
        commercialProject.setIntendedUse(intendedUseTextField.getText());
        commercialProject.setSize(Double.parseDouble(sizeTextField.getText()));
        commercialProject.setNumberOfFloors(Integer.parseInt(floorsTextField.getText()));
        break;
      case "Industrial":
        IndustrialProject industrialProject = (IndustrialProject) project;
        industrialProject.setIntendedUse(intendedUseTextField.getText());
        industrialProject.setSize(Double.parseDouble(sizeTextField.getText()));
        break;
      case "Road":
        RoadConstructionProject roadConstructionProject = (RoadConstructionProject) project;
        roadConstructionProject.setLength(Double.parseDouble(lengthTextField.getText()));
        roadConstructionProject.setWidth(Double.parseDouble(widthTextField.getText()));
        roadConstructionProject.setNumberOfBridges(Integer.parseInt(bridgesTextField.getText()));
        roadConstructionProject.setObstacles(obstaclesTextField.getText());
        break;
    }
    model.writeProjectsToBinaryFile();
    viewHandler.openView("details");
  };


}
