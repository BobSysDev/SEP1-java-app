package model;

import java.io.IOException;

public class ConstructionCompanyManager implements ConstructionCompanyModel
{
  private ConstructionCompanyModel model;

  private ProjectList projectList;
  private CustomerList customerList;
  private BinaryReaderWriter binaryFileInterface;
  private XMLReaderWriter xmlFileInterface;
  private static final String BINARY_FILE_PATH_PROJECTS = "projectsDB.bin";
  private static final String BINARY_FILE_PATH_CUSTOMERS = "customersDB.bin";

  public ConstructionCompanyManager()
  {
    projectList = new ProjectList();
    customerList = new CustomerList();
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
      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: \n" + e);
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
      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: \n" + e);
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



}
