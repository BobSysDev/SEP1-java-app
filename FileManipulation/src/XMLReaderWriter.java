import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class XMLReaderWriter implements ConstructionCompanyFile
{
  @Override public CustomerList readCustomerList(String path) throws IOException
  {
    File file = new File(path);
    ArrayList<String> lines = new ArrayList<String>();

    try(Scanner in = new Scanner(file)){
      while(in.hasNextLine()){
        lines.add(in.nextLine());
      }
    }

    CustomerList customers = new CustomerList();
    int counter = 2;
    while(!lines.get(counter).contains("</allCustomers>")){
      ArrayList<String> customerLines = new ArrayList<String>();
      while(!lines.get(counter).contains("</customer>")){
        customerLines.add(lines.get(counter));
        counter++;
      }
      counter++;
      customers.addCustomer(CustomerXMLReaderWriter.read(customerLines));
    }

    return customers;
  }

  @Override public void writeCustomerList(String path,
      CustomerList customerList) throws IOException
  {
    File file = new File(path);

    try(PrintWriter out = new PrintWriter(file)){
      ArrayList<Customer> customers = customerList.getCustomers();

      out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      out.println("<allCustomers>");

      for(Customer customer : customers){
        out.println(CustomerXMLReaderWriter.write(customer));
      }

      out.println("</allCustomers>");
    }
  }

  @Override public ProjectList readProjectList(String path) throws IOException
  {
    File file = new File(path);
    ArrayList<String> lines = new ArrayList<String>();

    try(Scanner in = new Scanner(file)){
      while(in.hasNextLine()){
        lines.add(in.nextLine());
      }
    }

    ProjectList projects = new ProjectList();
    int counter = 2;
    while(!lines.get(counter).contains("</allProjects>")){
      ArrayList<String> projectLines = new ArrayList<>();
      while(!lines.get(counter).contains("</project>")){
        projectLines.add(lines.get(counter));
        counter++;
      }
      counter++;
      if(projectLines.get(0).contains("type=\"Residential\"")){
        ResidentialProject resP = ResidentialXMLReaderWriter.read(projectLines);
        System.out.println(resP.getProjectID());
        projects.addProjectAndBypassIdCheck(resP);
      }
      else if(projectLines.get(0).contains("type=\"Commercial\"")){
        projects.addProjectAndBypassIdCheck(CommercialXMLReaderWriter.read(projectLines));
      }
      else if(projectLines.get(0).contains("type=\"Industrial\"")){
        projects.addProjectAndBypassIdCheck(IndustrialXMLReaderWriter.read(projectLines));
      }
      else if(projectLines.get(0).contains("type=\"Roadwork\"")){
        projects.addProjectAndBypassIdCheck(RoadXMLReaderWriter.read(projectLines));
      }
      else{
        throw new IOException("Project type not recognized");
      }
    }

    return projects;
  }

  @Override public void writeProjectList(String path, ProjectList projectList)
      throws IOException
  {
    File file = new File(path);

    try(PrintWriter out = new PrintWriter(file)){
      ArrayList<Project> projects = projectList.getProjects();

      out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      out.println("<allProjects>");

      for(Project project : projects){
        if(project instanceof ResidentialProject residentialProject){
          out.println(ResidentialXMLReaderWriter.write(residentialProject));
        }
        else if(project instanceof CommercialProject commercialProject){
          out.println(CommercialXMLReaderWriter.write(commercialProject));
        }
        else if(project instanceof IndustrialProject industrialProject){
          out.println(IndustrialXMLReaderWriter.write(industrialProject));
        }
        else if(project instanceof RoadConstructionProject roadConstructionProject){
          out.println(RoadXMLReaderWriter.write(roadConstructionProject));
        }
        else{
          throw new IOException("Project type not recognized");
        }
      }

      out.println("</allProjects>");
    }
  }
}
