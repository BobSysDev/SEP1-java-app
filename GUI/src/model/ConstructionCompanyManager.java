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

/**
 * A class that manages the project and customer lists. [TO BE CHANGED]
 *
 * @author Samuel Knieza
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 */

public class ConstructionCompanyManager implements ConstructionCompanyModel
{
  private ConstructionCompanyModel model;

  private ProjectList projectList;
  private CustomerList customerList;
  private BinaryReaderWriter binaryFileInterface;
  private XMLReaderWriter xmlFileInterface;

  private String pathForWebsiteRoot = "";
  private TXTFileHandlerForFilePathSettings txtFileHandlerForFilePathSettings;
  private static final String BINARY_FILE_PATH_PROJECTS = "projectDB.bin";
  private String xmlFilePathProjects = "projectDB.xml";
  private static final String BINARY_FILE_PATH_CUSTOMERS = "customerDB.bin";

  public ConstructionCompanyManager()
  {
    projectList = new ProjectList();
    customerList = new CustomerList();
    binaryFileInterface = new BinaryReaderWriter();
    xmlFileInterface = new XMLReaderWriter();
    txtFileHandlerForFilePathSettings = new TXTFileHandlerForFilePathSettings();
    pathForWebsiteRoot = "";
    pathForWebsiteRoot = readPathForWebsiteRoot();
    xmlFilePathProjects = pathForWebsiteRoot + "/xml/projectDB.xml";
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

  /**
   * Reads the project list from a binary file, using the BinaryReaderWriter class and stores it in a local variable. Shows a pop-up if the file is not found or could not be read.
   *
   * @see BinaryReaderWriter#readProjectList(String)
   */
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

  /**
   * Writes the project list to a binary file, using the BinaryReaderWriter class.
   *
   * @see BinaryReaderWriter#writeProjectList(String, ProjectList)
   */
  @Override
  public void writeProjectsToBinaryFile(){
    try{
      binaryFileInterface.writeProjectList(BINARY_FILE_PATH_PROJECTS, projectList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: \n" + e);
    }
  }

  /**
   * Reads the customer list from a binary file, using the BinaryReaderWriter class and stores it in a local variable. Shows a pop-up if the file is not found or could not be read.
   *
   * @see BinaryReaderWriter#readCustomerList(String)
   */

  @Override
  public void readCustomersFromBinaryFile(){
    try{
      customerList = binaryFileInterface.readCustomerList(BINARY_FILE_PATH_CUSTOMERS);
    }
    catch (IOException e){
//      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: \n" + e);
      if(Confirmation("Warning: database file not found", "File \"" + BINARY_FILE_PATH_CUSTOMERS + "\" could not be found. \nPress OK if you want to create a new empty file\nor CANCEL to close the application\n\n(If you're launching the app for the\nfirst time, press OK)")){
        writeCustomersToBinaryFile();
      }
      else{
        Platform.exit();
      }
    }
  }

  /**
   * Writes the customer list to a binary file, using the BinaryReaderWriter class.
   *
   * @see BinaryReaderWriter#writeCustomerList(String, CustomerList)
   */
  @Override
  public void writeCustomersToBinaryFile(){
    try{
      binaryFileInterface.writeCustomerList(BINARY_FILE_PATH_CUSTOMERS, customerList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: \n" + e);
    }
  }

  /**
   * Writes the project list to an XML file, using the XMLReaderWriter class.
   *
   * @see XMLReaderWriter#writeProjectList(String, ProjectList)
   */
  @Override public void writeProjectsToXMLFile(){
    try{
      xmlFileInterface.writeProjectList(xmlFilePathProjects, projectList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing to the XML file. Check the parameters. Printout: \n" + e);
    }
  }

  /**
   * Create a pop-up window with a warning message and two buttons: OK and CANCEL. Returns true if OK is pressed, false if CANCEL is pressed.
   */
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

  /**
   * Returns the path to the root folder of the website (2nd part of the Project).
   */
  public String getPathForWebsiteRoot(){
    return pathForWebsiteRoot;
  }

  /**
   * Reads the path to the root folder of the website (2nd part of the Project) from a text file, using the TXTFileHandlerForFilePathSettings class and stores it in a local variable. Shows a pop-up if the file is not found or could not be read, asking to set the path manually and then saves it back to the file.
   *
   * @see TXTFileHandlerForFilePathSettings#readSettingsFilePath()
   * @see TXTFileHandlerForFilePathSettings#writeSettingsFilePath(String)
   */
  public String readPathForWebsiteRoot(){
    String toReturn = null;
    try{
      toReturn = this.txtFileHandlerForFilePathSettings.readSettingsFilePath();
    }
    catch(FileNotFoundException e){
      if(Confirmation("Warning: the settings file wasn't found", "You can create a new one by clicking OK,\nor close the application by clicking cancel.\n\nIf this is the first time you're launching the app,\nclick OK to set a path that corresponds to the\nroot folder of your website (the one with index.html)")){
        try{
          String path = "";
          DirectoryChooser directoryChooser = new DirectoryChooser();
          directoryChooser.setTitle("Select the root folder of your website (the one with index.html)");
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

  /**
   * Sets the path to the root folder of the website (2nd part of the Project) and saves it to a text file, using the TXTFileHandlerForFilePathSettings class.
   *
   * @see TXTFileHandlerForFilePathSettings#writeSettingsFilePath(String)
   */
  public void setPathForWebsiteRoot(String pathForWebsiteRoot){
    this.pathForWebsiteRoot = pathForWebsiteRoot;

    try{
      this.txtFileHandlerForFilePathSettings.writeSettingsFilePath(pathForWebsiteRoot);
    }
    catch(FileNotFoundException e){
      System.out.println("ERROR: FileNotFoundException has occurred while writing to the settings file. Check the parameters. Printout: \n" + e);
    }
  }

  /**
   * Reads the provided XML file and reconstructs the project list from it, using the XMLReaderWriter class.
   *
   * @see XMLReaderWriter#readProjectList(String)
   */
  public void reconstructDataBaseFromXML() throws IOException
  {
    projectList = xmlFileInterface.readProjectList(xmlFilePathProjects);
    writeProjectsToBinaryFile();
  }

  /**
   * Reads the provided XML file and imports the projects from it to the project list, using the XMLReaderWriter class. It only imports the projects that are not already in the list.
   *
   * @see XMLReaderWriter#readProjectList(String)
   */
  public void importProjectsFromXML() throws IOException
  {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select the XML file that contains the projects you want to import");
    fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("XML files", "*.xml"));
    File selectedFile = fileChooser.showOpenDialog(null);

    ProjectList importedList = xmlFileInterface.readProjectList(selectedFile.getAbsolutePath());
    for(int i = 0; i < importedList.getSize(); i++){
      boolean duplicate = false;
      for(int j = 0; j < projectList.getSize(); j++){
        System.out.println("Comparing " + importedList.getProject(i).getProjectID() + " with " + projectList.getProject(j).getProjectID());
        System.out.println("Comparing " + importedList.getProject(i).getTitle() + " with " + projectList.getProject(j).getTitle());
        if(importedList.getProject(i).equals(projectList.getProject(j))){
          duplicate = true;
          break;
        }
      }
      if(!duplicate){
        projectList.addProject(importedList.getProject(i));
      }
    }
    writeProjectsToBinaryFile();
  }
}
