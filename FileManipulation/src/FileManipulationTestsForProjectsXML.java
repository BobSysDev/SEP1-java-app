import java.io.IOException;

public class FileManipulationTestsForProjectsXML
{
  public static void main(String[] args)
  {
    ProjectList projectList = new ProjectList();
    ResidentialProject residentialProject = new ResidentialProject("This guy's house", 420.25, 500, 5, 7, 540, 500, 0, false, "none", "rock and stone", 120, 1, 2, 1, true);
    CommercialProject commercialProject = new CommercialProject("Ikea Horsens", 123456, 5, 12, 9, 5200, 800, 0, false, "none", "mostly concrete", 69420, "Retail store");
    IndustrialProject industrialProject = new IndustrialProject("The factory", 123456, 5, 12, 9, 5200, 800, 0, false, "none", "mostly concrete", 69420, "Factory");
    RoadConstructionProject roadConstructionProject = new RoadConstructionProject("The road", 123456, 5, 12, 9, 5200, 800, 0, false, "none", "asphalt", 2000, 10, 2, "mountains");
    Customer customerA = new Customer(new Name("John", "Doe"), new Phone("45", "12345678"), new Email("johndoe", "gmail", "com"));
    Customer customerB = new Customer(new Name("Mark", "Stone"), new Phone("48", "123456789"), new Email("markstone", "totallylegitcompany", "net"), new CustomerCompany("Totally Legit Company", 213769420));
    Customer customerC = new Customer(new Name("Alex", "Smith"), new Phone("45", "12345678"), new Email("alexsmith", "gmail", "com"));
    Customer customerD = new Customer(new Name("Gordon", "Freeman"), new Phone("00", "111111111"), new Email("drfreeman", "blackmesa", "org"), new CustomerCompany("Black Mesa", 123456789));
    residentialProject.setCustomer(customerA);
    commercialProject.setCustomer(customerB);
    industrialProject.setCustomer(customerC);
    roadConstructionProject.setCustomer(customerD);

    projectList.addProject(residentialProject);
    projectList.addProject(commercialProject);
    projectList.addProject(industrialProject);
    projectList.addProject(roadConstructionProject);

    XMLReaderWriter xmlFileInterface = new XMLReaderWriter();

    try{
      xmlFileInterface.writeProjectList("projectDB.xml", projectList);
      System.out.println("Writing complete");
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: " + e);
    }

//    ProjectList retrievedList = new ProjectList();
//
//    try{
//      retrievedList = xmlFileInterface.readProjectList("projectDB.xml");
//      System.out.println("Reading complete");
//    }
//    catch (IOException e){
//      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: " + e);
//    }
//
//    System.out.println("Information retrieved. Displaying...");
//    System.out.println("==========================\nTest 1 of 1: Project 1\n");
//    System.out.println(retrievedList.getProject(0).getProjectID());
//    ResidentialProject resP2 = (ResidentialProject) retrievedList.getProject(0);
//    System.out.println(resP2.getNumberOfKitchens());
//    System.out.println(resP2.getNumberOfBathrooms());
//    System.out.println(resP2.isNewBuild());
//    System.out.println("==========================\nTest 2 of 2: Project 2\n");
//    System.out.println(retrievedList.getProject(1).getProjectID());
//    CommercialProject comP2 = (CommercialProject) retrievedList.getProject(1);
//    System.out.println(comP2.getType());
  }
}
