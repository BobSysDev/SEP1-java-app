public class ResidentialXMLWriter
{
  public static String write(ResidentialProject project){
    String XMLData = "";
    XMLData += "  <project type=\"Residential\">\n";
    XMLData += "    <projectId>" + project.getProjectID() + "</projectId>\n";
    XMLData += "    <title>" + project.getTitle() + "</title>\n";
    XMLData += "    <budgetEstimate>" + project.getBudgetEstimate() + "</budgetEstimate>\n";
    XMLData += "    <budget>" + project.getBudget() + "</budget>\n";
    XMLData += "    <timeEstimate>" + project.getTimeEstimate() + "</timeEstimate>\n";
    XMLData += "    <timeInterval>" + project.getTimeInterval() + "</timeInterval>\n";
    XMLData += "    <manHoursEstimate>" + project.getManHoursEstimate() + "</manHoursEstimate>\n";
    XMLData += "    <manHours>" + project.getManHours() + "</manHours>\n";
    XMLData += "    <isArchived>" + project.isArchived() + "</isArchived>\n";
    XMLData += "    <customer>\n";
    XMLData += "      <isPrivate>" + project.getCustomer().isPrivate() + "</isPrivate>\n";
    XMLData += "      <name>\n";
    XMLData += "        <firstName>" + project.getCustomer().getName().getFirstName() + "</firstName>\n";


    if(project.getCustomer().getName().getMiddleName() != null){
      XMLData += "        <middleName>" + project.getCustomer().getName().getMiddleName() + "</middleName>\n";
    }
    else {
      XMLData += "        <middleName></middleName>\n";
    }


    XMLData += "        <lastName>" + project.getCustomer().getName().getLastName() + "</lastName>\n";
    XMLData += "      </name>\n";
    XMLData += "      <email>\n";
    XMLData += "        <username>" + project.getCustomer().getEmail().getUser() + "</username>\n";
    XMLData += "        <host>" + project.getCustomer().getEmail().getHost() + "</host>\n";
    XMLData += "        <domain>" + project.getCustomer().getEmail().getDomain() + "</domain>\n";
    XMLData += "      </email>\n";
    XMLData += "      <phone>\n";
    XMLData += "        <countryCode>" + project.getCustomer().getPhone().getCountryCode() + "</countryCode>\n";
    XMLData += "        <number>" + project.getCustomer().getPhone().getPhoneNumber() + "</number>\n";
    XMLData += "      </phone>\n";

    if(!project.getCustomer().isPrivate()){
      XMLData += "      <customerCompany>\n";
      XMLData += "        <name>" + project.getCustomer().getCompany().getName() + "</name>\n";
      XMLData += "        <CVR>" + project.getCustomer().getCompany().getCVR() + "</CVR>\n";
      XMLData += "      </customerCompany>\n";
    }

    XMLData += "    </customer>\n";
    XMLData += "    <residential>\n";
    XMLData += "      <size>" + project.getSize() + "</size>\n";
    XMLData += "      <numberOfKitchens>" + project.getNumberOfKitchens() + "</numberOfKitchens>\n";
    XMLData += "      <numberOfBathrooms>" + project.getNumberOfBathrooms() + "</numberOfBathrooms>\n";
    XMLData += "      <numberOfOtherRoomsWithPlumbing>" + project.getOtherRoomsWithPlumbing() + "</numberOfOtherRoomsWithPlumbing>\n";
    XMLData += "      <isNewBuilding>" + project.isNewBuild() + "</isNewBuilding>\n";
    XMLData += "    </residential>\n";
    XMLData += "  </project>";

    return XMLData;
  }
}
