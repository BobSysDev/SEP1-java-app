package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for reading and writing XML files for CustomerList and ProjectList, dependent on other XMLReaderWriter classes (e.g. CustomerXMLReaderWriter) to function properly
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 * @see "ConstructionCompanyFile interface"
 */

public class XMLReaderWriter implements ConstructionCompanyFile
{
  /**
   * Reads CustomerList from the specified XML file
   * @param path String, path to the file. Can be relative or absolute
   * @return CustomerList object
   * @throws IOException if file could not be found or accessed
   */
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

  /**
   * Writes CustomerList to the specified XML file
   * @param path String, path to the file. Can be relative or absolute
   * @param customerList CustomerList object to be written
   * @throws IOException if file could not be found or accessed
   */
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

  /**
   * Reads ProjectList from the specified XML file
   * @param path String, path to the file. Can be relative or absolute
   * @return ProjectList object
   * @throws IOException if file could not be found or accessed
   */
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
        projects.addProjectAndBypassIdCheck(ResidentialXMLReaderWriter.read(projectLines));
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

  /**
   * Writes ProjectList to the specified XML file
   * @param path String, path to the file. Can be relative or absolute
   * @param projectList ProjectList object to be written
   * @throws IOException if file could not be found or accessed
   */
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
