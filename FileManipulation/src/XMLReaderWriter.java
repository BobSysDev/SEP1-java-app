import javafx.print.Printer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class XMLReaderWriter implements ConstructionCompanyFile
{
  @Override public CustomerList readCustomerList(String path) throws IOException
  {
    return null;
  }

  @Override public void writeCustomerList(String path,
      CustomerList customerList) throws IOException
  {

  }

  @Override public ProjectList readProjectList(String path) throws IOException
  {
    return null;
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
          out.println(ResidentialXMLWriter.write(residentialProject));
        }
        else if(project instanceof CommercialProject commercialProject){
          out.println(CommercialXMLWriter.write(commercialProject));
        }
        else if(project instanceof IndustrialProject industrialProject){
          out.println(IndustrialXMLWriter.write(industrialProject));
        }
        else if(project instanceof RoadConstructionProject roadConstructionProject){
          out.println(RoadXMLWriter.write(roadConstructionProject));
        }
        else{
          throw new IOException("Project type not recognized");
        }
      }

      out.println("</allProjects>");
    }
  }
}
