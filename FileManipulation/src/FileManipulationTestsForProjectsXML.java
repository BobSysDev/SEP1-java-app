import java.io.IOException;
import java.util.ArrayList;

public class FileManipulationTestsForProjectsXML
{
  public static void main(String[] args)
  {
    ProjectList projectList = new ProjectList();
    ResidentialProject residentialProject = new ResidentialProject(
        "ZThis guy's house", 420.25, 500, 5, 7, 540, 500, 0, false, "none",
        "rock and stone", 120, 1, 2, 1, true);
    CommercialProject commercialProject = new CommercialProject("BIkea Horsens",
        120, 5, 12, 9, 5200, 800, 0, false, "none", "mostly concrete", 69420,
        "Retail store");
    IndustrialProject industrialProject = new IndustrialProject("AThe factory",
        69, 5, 12, 9, 5200, 800, 0, false, "none", "mostly concrete", 69420,
        "Factory");
    RoadConstructionProject roadConstructionProject = new RoadConstructionProject(
        "GThe road", 75.3, 5, 12, 9, 5200, 800, 0, false, "none", "asphalt",
        2000, 10, 2, "mountains");
    Customer customerA = new Customer(new Name("John", "Doe"), new Phone("45", "12345678"), new Email("johndoe", "gmail", "com"));
    Customer customerB = new Customer(new Name("Mark", "Stone"), new Phone("48", "123456789"),
        new Email("markstone", "totallylegitcompany", "net"), new CustomerCompany("Totally Legit Company", "213769420"));
    Customer customerC = new Customer(new Name("Alex", "Smith"), new Phone("45", "12345678"), new Email("alexsmith", "gmail", "com"));
    Customer customerD = new Customer(new Name("Gordon", "Freeman"), new Phone("00", "111111111"),
        new Email("drfreeman", "blackmesa", "org"), new CustomerCompany("Black Mesa", "123456789"));
    residentialProject.setCustomer(customerA);
    commercialProject.setCustomer(customerB);
    industrialProject.setCustomer(customerC);
    roadConstructionProject.setCustomer(customerD);

    projectList.addProject(residentialProject);
    projectList.addProject(commercialProject);
    projectList.addProject(industrialProject);
    projectList.addProject(roadConstructionProject);

    XMLReaderWriter xmlFileInterface = new XMLReaderWriter();

    try
    {
      xmlFileInterface.writeProjectList("projectDB.xml", projectList);
      System.out.println("Writing complete");
    }
    catch (IOException e)
    {
      System.out.println(
          "ERROR: IOException has occurred while writing. Check the parameters. Printout: "
              + e);
    }

        ProjectList retrievedList = new ProjectList();

        try{
          retrievedList = xmlFileInterface.readProjectList("projectDB.xml");
          System.out.println("Reading complete");
        }
        catch (IOException e){
          System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: " + e);
        }

        ArrayList<Project> sortedProjects = retrievedList.getProjectsSortedByBudget();

        System.out.println("Information retrieved. Displaying...");
        System.out.println("==========================\nTest 1 of 4: Project 1\n");
        System.out.println(sortedProjects.get(0).getProjectID());
        System.out.println(sortedProjects.get(0).getTitle());
        System.out.println(sortedProjects.get(0).getBudget());
//        ResidentialProject resP2 = (ResidentialProject) retrievedList.getProject(0);
//        System.out.println(resP2.getTitle());
//        System.out.println(resP2.getNumberOfKitchens());
//        System.out.println(resP2.getNumberOfBathrooms());
//        System.out.println(resP2.isNewBuild());

        System.out.println("==========================\nTest 2 of 4: Project 2\n");
        System.out.println(sortedProjects.get(1).getProjectID());
        System.out.println(sortedProjects.get(1).getTitle());
        System.out.println(sortedProjects.get(1).getBudget());
//        CommercialProject comP2 = (CommercialProject) retrievedList.getProject(1);
//        System.out.println(comP2.getTitle());
//        System.out.println(comP2.getSize());
//        System.out.println(comP2.getType());

        System.out.println("==========================\nTest 3 of 4: Project 3\n");
        System.out.println(sortedProjects.get(2).getProjectID());
        System.out.println(sortedProjects.get(2).getTitle());
        System.out.println(sortedProjects.get(2).getBudget());
//        IndustrialProject indP2 = (IndustrialProject) retrievedList.getProject(2);
//        System.out.println(indP2.getTitle());
//        System.out.println(indP2.getSize());
//        System.out.println(indP2.getType());

        System.out.println("==========================\nTest 4 of 4: Project 4\n");
        System.out.println(sortedProjects.get(3).getProjectID());
        System.out.println(sortedProjects.get(3).getTitle());
        System.out.println(sortedProjects.get(3).getBudget());
//        RoadConstructionProject roadP2 = (RoadConstructionProject) retrievedList.getProject(3);
//        System.out.println(roadP2.getTitle());
//        System.out.println(roadP2.getLength());
//        System.out.println(roadP2.getWidth());
//        System.out.println(roadP2.getNumberOfBridges());
//        System.out.println(roadP2.getObstacles());
  }
}
