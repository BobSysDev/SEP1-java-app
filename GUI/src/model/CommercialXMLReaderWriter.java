package model;

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
    XMLData += "    <details>" + project.getDetails() + "</details>\n";
    XMLData += "    <materials>" + project.getMaterials() + "</materials>\n";
    XMLData += "    <isArchived>" + project.isArchived() + "</isArchived>\n";
    XMLData += "    <startDate>" + project.getStartDate() + "</startDate>\n";
    XMLData += "    <coverImage>" + project.getPhotoPathForWebsite() + "</coverImage>\n";

    XMLData += CustomerXMLReaderWriter.write(project.getCustomer()) + "\n";

    XMLData += "    <commercial>\n";
    XMLData += "      <size>" + project.getSize() + "</size>\n";
    XMLData += "      <numberOfFloors>" + project.getNumberOfFloors() + "</numberOfFloors>\n";
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
    String details = lines.get(9).replace("<details>", "").replace("</details>", "").trim();
    String materials = lines.get(10).replace("<materials>", "").replace("</materials>", "").trim();
    boolean isArchived = Boolean.parseBoolean(lines.get(11).replace("<isArchived>", "").replace("</isArchived>", "").trim());
    String startDate = lines.get(12).replace("<startDate>", "").replace("</startDate>", "").trim();
    String photoPathForWebsite = lines.get(13).replace("<coverImage>", "").replace("</coverImage>", "").trim();

    int counter = 14;
    ArrayList<String> customerLines = new ArrayList<>();
    while(!lines.get(counter).contains("</customer>")){
      customerLines.add(lines.get(counter));
      counter++;
    }
    counter += 2;
    Customer customer = CustomerXMLReaderWriter.read(customerLines);

    double size = Double.parseDouble(lines.get(counter).replace("<size>", "").replace("</size>", "").trim());
    int numberOfFloors = Integer.parseInt(lines.get(counter + 1).replace("<numberOfFloors>", "").replace("</numberOfFloors>", "").trim());
    String type = lines.get(counter + 2).replace("<type>", "").replace("</type>", "").trim();

    CommercialProject commercialProject = new CommercialProject(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, "", "", size, type, numberOfFloors, startDate, customer);
    commercialProject.setDetails(details);
    commercialProject.setMaterials(materials);
    commercialProject.setPhotoPathForWebsite(photoPathForWebsite);
    return commercialProject;
  }
}
