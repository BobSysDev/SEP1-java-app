import java.util.ArrayList;

public class CommercialXMLReaderWriter
{
  public static String write(CommercialProject project){
    String XMLData = "";
    XMLData += "  <project type=\"Commercial\">\n";
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

    XMLData += "    <commercial>\n";
    XMLData += "      <size>" + project.getSize() + "</size>\n";
    XMLData += "      <type>" + project.getType() + "</type>\n";
    XMLData += "    </commercial>\n";
    XMLData += "  </project>";

    return XMLData;
  }

  public static CommercialProject read(ArrayList<String> lines){
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

    double size = Double.parseDouble(lines.get(counter).replace("<size>", "").replace("</size>", "").trim());
    String type = lines.get(counter + 1).replace("<type>", "").replace("</type>", "").trim();

    CommercialProject commercialProject = new CommercialProject(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, "", "", size, type);
    commercialProject.setCustomer(customer);
    return commercialProject;
  }
}
