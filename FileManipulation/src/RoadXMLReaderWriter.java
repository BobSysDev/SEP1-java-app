import java.util.ArrayList;

public class RoadXMLReaderWriter
{
  public static String write(RoadConstructionProject project){
    String XMLData = "";
    XMLData += "  <project type=\"Roadwork\">\n";
    XMLData += "    <projectId>" + project.getProjectID() + "</projectId>\n";
    XMLData += "    <title>" + project.getTitle() + "</title>\n";
    XMLData += "    <budgetEstimate>" + project.getBudgetEstimate() + "</budgetEstimate>\n";
    XMLData += "    <budget>" + project.getBudget() + "</budget>\n";
    XMLData += "    <timeEstimate>" + project.getTimeEstimate() + "</timeEstimate>\n";
    XMLData += "    <timeInterval>" + project.getTimeInterval() + "</timeInterval>\n";
    XMLData += "    <manHoursEstimate>" + project.getManHoursEstimate() + "</manHoursEstimate>\n";
    XMLData += "    <manHours>" + project.getManHours() + "</manHours>\n";
    XMLData += "    <isArchived>" + project.isArchived() + "</isArchived>\n";

    XMLData += CustomerXMLReaderWriter.write(project.getCustomer()) + "\n";

    XMLData += "    <roadwork>\n";
    XMLData += "      <length>" + project.getLength() + "</length>\n";
    XMLData += "      <width>" + project.getWidth() + "</width>\n";
    XMLData += "      <numberOfBridges>" + project.getNumberOfBridges() + "</numberOfBridges>\n";
    XMLData += "      <obstacles>" + project.getObstacles() + "</obstacles>\n";
    XMLData += "    </roadwork>\n";
    XMLData += "  </project>";

    return XMLData;
  }

  public static RoadConstructionProject read(ArrayList<String> lines){
    int projectID = Integer.parseInt(lines.get(1).replace("<projectId>", "").replace("</projectId>", "").trim());
    String title = lines.get(2).replace("<title>", "").replace("</title>", "").trim();
    double budgetEstimate = Double.parseDouble(lines.get(3).replace("<budgetEstimate>", "").replace("</budgetEstimate>", "").trim());
    double budget = Double.parseDouble(lines.get(4).replace("<budget>", "").replace("</budget>", "").trim());
    int timeEstimate = Integer.parseInt(lines.get(5).replace("<timeEstimate>", "").replace("</timeEstimate>", "").trim());
    int timeInterval = Integer.parseInt(lines.get(6).replace("<timeInterval>", "").replace("</timeInterval>", "").trim());
    double manHoursEstimate = Double.parseDouble(lines.get(7).replace("<manHoursEstimate>", "").replace("</manHoursEstimate>", "").trim());
    double manHours = Double.parseDouble(lines.get(8).replace("<manHours>", "").replace("</manHours>", "").trim());
    boolean isArchived = Boolean.parseBoolean(lines.get(9).replace("<isArchived>", "").replace("</isArchived>", "").trim());

    int counter = 10;
    ArrayList<String> customerLines = new ArrayList<>();
    while(!lines.get(counter).contains("</customer>")){
      customerLines.add(lines.get(counter));
      counter++;
    }
    counter += 2;
    Customer customer = CustomerXMLReaderWriter.read(customerLines);

    double length = Double.parseDouble(lines.get(counter).replace("<length>", "").replace("</length>", "").trim());
    double width = Double.parseDouble(lines.get(counter + 1).replace("<width>", "").replace("</width>", "").trim());
    int numberOfBridges = Integer.parseInt(lines.get(counter + 2).replace("<numberOfBridges>", "").replace("</numberOfBridges>", "").trim());
    String obstacles = lines.get(counter + 3).replace("<obstacles>", "").replace("</obstacles>", "").trim();

    RoadConstructionProject roadConstructionProject = new RoadConstructionProject(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, "", "", length, width, numberOfBridges, obstacles);
    roadConstructionProject.setCustomer(customer);
    return roadConstructionProject;
  }
}
