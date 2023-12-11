package view;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


import java.util.Optional;

public class DetailsViewController
{
  //header
  @FXML private Label headerTypeLabel;
  @FXML private Label headerNameLabel;

  //buttons
  @FXML private Button makeOngoingButton;
  @FXML private Button archiveButton;

  //1st section
  @FXML private Label typeLabel;
  @FXML private Label nameLabel;
  @FXML private Label idLabel;
  @FXML private Label clientLabel;
  @FXML private Label phoneLabel;
  @FXML private Label emailLabel;
  @FXML private Label startDateLabel;
  @FXML private Label durationLabel;
  @FXML private Text companyNameText;
  @FXML private Text cvrText;
  @FXML private Label cvrLabel;
  @FXML private Label companyNameLabel;

  //materials
  @FXML private Label materialsLabel;

  //table
  @FXML private Label eManHoursLabel;
  @FXML private Label eBudgetLabel;
  @FXML private Label aManHoursLabel;
  @FXML private Label aBudgetLabel;

  //properties
  @FXML private Label bathroomsLabel;
  @FXML private Text bathroomsText;
  @FXML private Label kitchensLabel;
  @FXML private Text kitchensText;
  @FXML private Label plumbingLabel;
  @FXML private Text plumbingText;
  @FXML private Label sizeLabel;
  @FXML private Text sizeText;
  @FXML private Label newBuildLabel;
  @FXML private Text newBuildText;
  @FXML private Label intendedUseLabel;
  @FXML private Text intendedUseText;
  @FXML private Label floorsLabel;
  @FXML private Text floorsText;
  @FXML private Label lengthLabel;
  @FXML private Text lengthText;
  @FXML private Label widthLabel;
  @FXML private Text widthText;
  @FXML private Label bridgesLabel;
  @FXML private Text bridgesText;
  @FXML private Label obstaclesLabel;
  @FXML private Text obstaclesText;





  //details
  @FXML private Label detailsLabel;


  private Region root;
  private ConstructionCompanyModel model;
  private ViewHandler viewHandler;
  private ProjectViewController projectViewController;
  private ProjectListViewModel viewModel;

  public DetailsViewController(){}

  public void init(Region root, ConstructionCompanyModel model, ViewHandler viewHandler, ProjectViewController projectViewController, ProjectListViewModel viewModel)
  {
    this.root = root;
    this.model = model;
    this.viewHandler = viewHandler;
    this.projectViewController = projectViewController;
    this.viewModel = viewModel;

    setProjectDetails();
    displayButtons();
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
    Project project = model.getProjectByID(id);


    //setting the labels to selected project properties
    headerTypeLabel.setText(project.getType());
    headerNameLabel.setText(project.getTitle());
    nameLabel.setText(project.getTitle());
    typeLabel.setText(project.getType());
    idLabel.setText(String.valueOf(project.getProjectID()));
    clientLabel.setText(project.getCustomer().getName().getFullName());
    phoneLabel.setText(project.getCustomer().getPhone().getFullPhoneNumber());
    emailLabel.setText(project.getCustomer().getEmail().getFullEmail());

    if (project.getCustomer().getCompany() != null){
      companyNameLabel.setText(project.getCustomer().getCompany().getFullCompanyName());
      cvrLabel.setText(project.getCustomer().getCompany().getCVR());
    }
    else {
      companyNameLabel.setVisible(false);
      companyNameText.setVisible(false);
      cvrLabel.setVisible(false);
      cvrText.setVisible(false);
    }

    startDateLabel.setAlignment(Pos.CENTER_RIGHT);
    durationLabel.setAlignment(Pos.CENTER_RIGHT);
    startDateLabel.setText(project.getStartDate());
    durationLabel.setText(String.valueOf(project.getTimeEstimate()));

    materialsLabel.setAlignment(Pos.TOP_CENTER);
    materialsLabel.setText(project.getMaterials());
    eManHoursLabel.setText(String.valueOf(project.getManHoursEstimate()));
    aManHoursLabel.setText(String.valueOf(project.getManHours()));
    eBudgetLabel.setText(String.valueOf(project.getBudgetEstimate()));
    aBudgetLabel.setText(String.valueOf(project.getBudget()));
    detailsLabel.setAlignment(Pos.TOP_CENTER);
    detailsLabel.setText(project.getDetails());

    //displaying labels depending on selected project type
    String type = project.getType();

    switch (type){
      case "Residential":
        ResidentialProject residentialProject = (ResidentialProject) project;
        bathroomsLabel.setText(String.valueOf(residentialProject.getNumberOfBathrooms()));
        kitchensLabel.setText(String.valueOf(residentialProject.getNumberOfKitchens()));
        plumbingLabel.setText(String.valueOf(residentialProject.getOtherRoomsWithPlumbing()));
        sizeLabel.setText(String.valueOf(residentialProject.getSize()));
        String newBuild = "Yes";
        if (!residentialProject.isNewBuild()){
          newBuild = "No";
        }
        newBuildLabel.setText(newBuild);
        intendedUseLabel.setVisible(false);
        intendedUseText.setVisible(false);
        floorsLabel.setVisible(false);
        floorsText.setVisible(false);
        lengthLabel.setVisible(false);
        lengthText.setVisible(false);
        widthLabel.setVisible(false);
        widthText.setVisible(false);
        bridgesLabel.setVisible(false);
        bridgesText.setVisible(false);
        obstaclesLabel.setVisible(false);
        obstaclesText.setVisible(false);

        break;
      case "Commercial":
        CommercialProject commercialProject = (CommercialProject) project;
        sizeLabel.setText(String.valueOf(commercialProject.getSize()));
        intendedUseLabel.setText(commercialProject.getIntendedUse());
        floorsLabel.setText(String.valueOf(commercialProject.getNumberOfFloors()));

        bathroomsLabel.setVisible(false);
        bathroomsText.setVisible(false);
        kitchensLabel.setVisible(false);
        kitchensText.setVisible(false);
        plumbingLabel.setVisible(false);
        plumbingText.setVisible(false);
        newBuildLabel.setVisible(false);
        newBuildText.setVisible(false);

        lengthLabel.setVisible(false);
        lengthText.setVisible(false);
        widthLabel.setVisible(false);
        widthText.setVisible(false);
        bridgesLabel.setVisible(false);
        bridgesText.setVisible(false);
        obstaclesLabel.setVisible(false);
        obstaclesText.setVisible(false);

        break;
      case "Industrial":
        IndustrialProject industrialProject = (IndustrialProject) project;
        sizeLabel.setText(String.valueOf(industrialProject.getSize()));
        intendedUseLabel.setText(industrialProject.getIntendedUse());

        bathroomsLabel.setVisible(false);
        bathroomsText.setVisible(false);
        kitchensLabel.setVisible(false);
        kitchensText.setVisible(false);
        plumbingLabel.setVisible(false);
        plumbingText.setVisible(false);
        newBuildLabel.setVisible(false);
        newBuildText.setVisible(false);
        floorsLabel.setVisible(false);
        floorsText.setVisible(false);

        lengthLabel.setVisible(false);
        lengthText.setVisible(false);
        widthLabel.setVisible(false);
        widthText.setVisible(false);
        bridgesLabel.setVisible(false);
        bridgesText.setVisible(false);
        obstaclesLabel.setVisible(false);
        obstaclesText.setVisible(false);

        break;
      case "Road":
        RoadConstructionProject roadConstructionProject = (RoadConstructionProject) project;
        lengthLabel.setText(String.valueOf(roadConstructionProject.getLength()));
        widthLabel.setText(String.valueOf(roadConstructionProject.getWidth()));
        bridgesLabel.setText(String.valueOf(roadConstructionProject.getNumberOfBridges()));
        obstaclesLabel.setText(roadConstructionProject.getObstacles());

        sizeText.setVisible(false);
        sizeLabel.setVisible(false);
        bathroomsLabel.setVisible(false);
        bathroomsText.setVisible(false);
        kitchensLabel.setVisible(false);
        kitchensText.setVisible(false);
        plumbingLabel.setVisible(false);
        plumbingText.setVisible(false);
        newBuildLabel.setVisible(false);
        newBuildText.setVisible(false);
        floorsLabel.setVisible(false);
        floorsText.setVisible(false);
        intendedUseLabel.setVisible(false);
        intendedUseText.setVisible(false);
        break;
    }

  }

  public void displayButtons(){
    int id = projectViewController.getProjectID(projectViewController.getSelectedTab());
    Project project = model.getProjectByID(id);
    if (project.isArchived()){
      makeOngoingButton.setVisible(true);
      archiveButton.setVisible(false);
    }
    else {
      makeOngoingButton.setVisible(false);
      archiveButton.setVisible(true);
    }
  }

  @FXML public void archiveButtonPressed(){
    int id = projectViewController.getProjectID(projectViewController.getSelectedTab());
    Project project = model.getProjectByID(id);
    project.setArchived(true);
    model.writeProjectsToBinaryFile();
    viewHandler.openView("projects");
  }

  @FXML public void makeOngoingButtonPressed(){
    int id = projectViewController.getProjectID(projectViewController.getSelectedTab());
    Project project = model.getProjectByID(id);
    project.setArchived(false);
    model.writeProjectsToBinaryFile();
    viewHandler.openView("projects");

  }
  @FXML public void editButtonPressed(){
    viewHandler.openView("edit details");
  }
  @FXML public void deleteButtonPressed(){
    int id = projectViewController.getProjectID(projectViewController.getSelectedTab());
    Project project = model.getProjectByID(id);
    model.removeProject(project);
    model.writeProjectsToBinaryFile();
    viewHandler.openView("projects");
  }
  @FXML public void backButtonPressed(){
    viewHandler.openView("projects");
  }


}
