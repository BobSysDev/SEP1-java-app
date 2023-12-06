package model;

import java.io.IOException;

public class FileManipulationTestsForProjects
{
  public static void main(String[] args)
  {
    ProjectList projectList = new ProjectList();
    Customer customerA = new Customer(new Name("John", "Doe"), new Phone("45", "12345678"), new Email("johndoe", "gmail", "com"));
    ResidentialProject residentialProject = new ResidentialProject("This guy's house", 420.25, 500, 5, 7, 540, 500, 0, true, "none", "rock and stone", 120, 1, 2, 1, true, "house", "01.02.2021", customerA);
    CommercialProject commercialProject = new CommercialProject("Ikea Horsens", 123456, 5, 12, 9, 5200, 800, 0, false, "none", "mostly concrete", 69420, "Retail store", "03.02.2021", customerA);
    residentialProject.setCustomer(customerA);

    projectList.addProject(residentialProject);
    projectList.addProject(commercialProject);

    BinaryReaderWriter binaryFileInterface = new BinaryReaderWriter();

    try{
      binaryFileInterface.writeProjectList("projectDB.bin", projectList);
      System.out.println("Writing complete");
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: " + e);
    }

    ProjectList retrievedList = new ProjectList();

    try{
      retrievedList = binaryFileInterface.readProjectList("projectDB.bin");
      System.out.println("Reading complete");
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: " + e);
    }

    System.out.println("Information retrieved. Displaying...");
    System.out.println("==========================\nTest 1 of 2: Project 1\n");
    System.out.println(retrievedList.getProject(0).getProjectID());
    System.out.println(retrievedList.getProject(0).getTitle());
    ResidentialProject resP2 = (ResidentialProject) retrievedList.getProject(0);
    System.out.println(resP2.getNumberOfKitchens());
    System.out.println(resP2.getNumberOfBathrooms());
    System.out.println(resP2.isNewBuild());
    System.out.println("==========================\nTest 2 of 2: Project 2\n");
    System.out.println(retrievedList.getProject(1).getProjectID());
    System.out.println(retrievedList.getProject(1).getTitle());
    CommercialProject comP2 = (CommercialProject) retrievedList.getProject(1);
    System.out.println(comP2.getType());
  }
}
