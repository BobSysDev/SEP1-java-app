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
  @FXML private TextField typeTextField;
  @FXML private TextField nameTextField;
  @FXML private Label idLabel;
  @FXML private TextField clientTextField;
  @FXML private TextField phoneTextField;
  @FXML private TextField emailTextField;
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
    typeTextField.setText(project.getType());
    idLabel.setText(String.valueOf(project.getProjectID()));
    clientTextField.setText(project.getCustomer().getName().getFullName());
    phoneTextField.setText(project.getCustomer().getPhone().getFullPhoneNumber());
    emailTextField.setText(project.getCustomer().getEmail().getFullEmail());

    if (project.getCustomer().getCompany() != null){
      companyNameTextField.setText(project.getCustomer().getCompany().getFullCompanyName());
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
        String newBuild = "Yes";
        if (!residentialProject.isNewBuild()){
          newBuild = "No";
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
  @FXML public void saveButtonPressed(){};
  @FXML public void isNewBuild(){};


}
