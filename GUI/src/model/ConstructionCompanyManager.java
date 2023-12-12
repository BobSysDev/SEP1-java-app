package model;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class ConstructionCompanyManager implements ConstructionCompanyModel
{
  private ConstructionCompanyModel model;

  private ProjectList projectList;
  private CustomerList customerList;
  private BinaryReaderWriter binaryFileInterface;
  private XMLReaderWriter xmlFileInterface;

  private String pathForPhotosForTheWebsite = "";
  private TXTFileHandlerForFilePathSettings txtFileHandlerForFilePathSettings;
  private static final String BINARY_FILE_PATH_PROJECTS = "projectDB.bin";
  private static final String XML_FILE_PATH_PROJECTS = "projectDB.xml";
  private static final String BINARY_FILE_PATH_CUSTOMERS = "customerDB.bin";

  public ConstructionCompanyManager()
  {
    projectList = new ProjectList();
    customerList = new CustomerList();
    binaryFileInterface = new BinaryReaderWriter();
    xmlFileInterface = new XMLReaderWriter();
    txtFileHandlerForFilePathSettings = new TXTFileHandlerForFilePathSettings();
    pathForPhotosForTheWebsite = "";
    readPathForPhotosForTheWebsite();
    readCustomersFromBinaryFile();
    readProjectsFromBinaryFile();
  }

  @Override
  public void addProject(Project project){
    projectList.addProject(project);
  }

  @Override
  public void removeProject(Project project){
      projectList.removeProject(project);
  }

  @Override public int listSize()
  {
    return projectList.getSize();
  }

  @Override public Project getProject(int index)
  {
    return projectList.getProject(index);
  }

  @Override public Project getProjectByID(int id)
  {
    for (int i = 0; i < projectList.getSize(); i++)
    {
      Project tmp = projectList.getProject(i);
      if (tmp.getProjectID()==id){
        return tmp;
      }
    }
    return null;
  }

  //public void getProjectByID(int =======)

  @Override
  public void addCustomer(Customer customer){
    customerList.addCustomer(customer);
  }

  @Override
  public void removeCustomer(Customer customer){
    customerList.removeCustomer(customer);
  }
  @Override
  public void readProjectsFromBinaryFile(){
    try{
      projectList = binaryFileInterface.readProjectList(BINARY_FILE_PATH_PROJECTS);
    }
    catch (IOException e){
//      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: \n" + e);
      if(Confirmation("Warning: database file not found", "File \"" + BINARY_FILE_PATH_PROJECTS + "\" could not be found. \nPress OK if you want to create a new empty file\nor CANCEL to close the application.\n\n(If you're launching the app for the\nfirst time, press OK)")){
        writeProjectsToBinaryFile();
      }
      else{
        Platform.exit();
      }
    }
  }
  @Override
  public void writeProjectsToBinaryFile(){
    try{
      binaryFileInterface.writeProjectList(BINARY_FILE_PATH_PROJECTS, projectList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: \n" + e);
    }
  }
  @Override
  public void readCustomersFromBinaryFile(){
    try{
      customerList = binaryFileInterface.readCustomerList(BINARY_FILE_PATH_CUSTOMERS);
    }
    catch (IOException e){
//      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: \n" + e);
      if(Confirmation("Warning: database file not found", "File \"" + BINARY_FILE_PATH_CUSTOMERS + "\" could not be found. \nPress OK if you want to create a new empty file\nor CANCEL to close the application\n\n(If you're launching the app for the\nfirst time, press OK)")){
        writeProjectsToBinaryFile();
      }
      else{
        Platform.exit();
      }
    }
  }
  @Override
  public void writeCustomersToBinaryFile(){
    try{
      binaryFileInterface.writeCustomerList(BINARY_FILE_PATH_CUSTOMERS, customerList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: \n" + e);
    }
  }

  @Override public void writeProjectsToXMLFile(){
    try{
      xmlFileInterface.writeProjectList(XML_FILE_PATH_PROJECTS, projectList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing to the XML file. Check the parameters. Printout: \n" + e);
    }
  }

  public boolean Confirmation(String title, String query){
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(title);
    alert.setHeaderText(query);

    alert.getButtonTypes().clear();
    alert.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    Button createNew = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
    createNew.setDefaultButton(false);

    Button quit = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
    quit.setDefaultButton(true);

    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent()) && (result.get() == ButtonType.OK);
  }

  public String getPathForPhotosForTheWebsite(){
    return pathForPhotosForTheWebsite;
  }

  public String readPathForPhotosForTheWebsite(){
    String toReturn = null;
    try{
      toReturn = this.txtFileHandlerForFilePathSettings.readSettingsFilePath();
    }
    catch(FileNotFoundException e){
      if(Confirmation("Warning: the settings file wasn't found", "You can create a new one by clicking OK,\nor close the application by clicking cancel.\n\nIf this is the first time you're launching the app,\nclick OK to set a path to which the cover\nphotos fot the website will be copied.")){
        try{
          String path = "";
          DirectoryChooser directoryChooser = new DirectoryChooser();
          directoryChooser.setTitle("Select a folder that will contain the cover photos for the website");
          File selectedFile = directoryChooser.showDialog(null);
          path = selectedFile.getAbsolutePath();
          this.txtFileHandlerForFilePathSettings.writeSettingsFilePath(path);
          return path;
        }
        catch(FileNotFoundException e2){
          System.out.println("ERROR: FileNotFoundException has occurred while writing to the settings file. Check the parameters. Printout: \n" + e2);
        }
      }
      else{
        Platform.exit();
      }
    }
    return toReturn;
  }

  public void setPathForPhotosForTheWebsite(String pathForPhotosForTheWebsite){
    this.pathForPhotosForTheWebsite = pathForPhotosForTheWebsite;

    try{
      this.txtFileHandlerForFilePathSettings.writeSettingsFilePath(pathForPhotosForTheWebsite);
    }
    catch(FileNotFoundException e){
      System.out.println("ERROR: FileNotFoundException has occurred while writing to the settings file. Check the parameters. Printout: \n" + e);
    }
  }

  public void reconstructDataBaseFromXML() throws IOException
  {
    projectList = xmlFileInterface.readProjectList(XML_FILE_PATH_PROJECTS);
    writeProjectsToBinaryFile();
  }

  public void importProjectsFromXML() throws IOException
  {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select the XML file that contains the projects you want to import");
    fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("XML files", "*.xml"));
    File selectedFile = fileChooser.showOpenDialog(null);

    ProjectList importedList = xmlFileInterface.readProjectList(selectedFile.getAbsolutePath());
    for(int i = 0; i < importedList.getSize(); i++){
      projectList.addProject(importedList.getProject(i));
    }
    writeProjectsToBinaryFile();
  }
}
