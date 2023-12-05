import java.io.*;
import java.util.List;

public class ConstructionCompanyManager
{
  private ProjectList projectList;
  private CustomerList customerList;
  private BinaryReaderWriter binaryFileInterface;
  private XMLReaderWriter xmlFileInterface;
  private static final String BINARY_FILE_PATH_PROJECTS = "projectDB.bin";
  private static final String BINARY_FILE_PATH_CUSTOMERS = "customerDB.bin";

  public ConstructionCompanyManager()
  {
    projectList = new ProjectList();
    customerList = new CustomerList();
    readCustomersFromBinaryFile();
    readProjectsFromBinaryFile();
  }

  public void addProject(Project project){
    projectList.addProject(project);
  }


  public void removeProject(Project project){
      projectList.removeProject(project);
  }

  //public void getProjectByID(int =======)


  public void addCustomer(Customer customer){
    customerList.addCustomer(customer);
  }


  public void removeCustomer(Customer customer){
    customerList.removeCustomer(customer);
  }

  public void readProjectsFromBinaryFile(){
    try{
      projectList = binaryFileInterface.readProjectList(BINARY_FILE_PATH_PROJECTS);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: \n" + e);
    }
  }

  public void writeProjectsToBinaryFile(){
    try{
      binaryFileInterface.writeProjectList(BINARY_FILE_PATH_PROJECTS, projectList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: \n" + e);
    }
  }

  public void readCustomersFromBinaryFile(){
    try{
      customerList = binaryFileInterface.readCustomerList(BINARY_FILE_PATH_CUSTOMERS);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: \n" + e);
    }
  }

  public void writeCustomersToBinaryFile(){
    try{
      binaryFileInterface.writeCustomerList(BINARY_FILE_PATH_CUSTOMERS, customerList);
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: \n" + e);
    }
  }



}
