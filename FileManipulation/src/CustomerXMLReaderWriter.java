import java.util.ArrayList;

public class CustomerXMLReaderWriter
{
  public static String write(Customer customer){
    String XMLData = "";

    XMLData += "    <customer>\n";
    XMLData += "      <isPrivate>" + customer.isPrivate() + "</isPrivate>\n";
    XMLData += "      <name>\n";
    XMLData += "        <firstName>" + customer.getName().getFirstName() + "</firstName>\n";


    if(customer.getName().getMiddleName() != null){
      XMLData += "        <middleName>" + customer.getName().getMiddleName() + "</middleName>\n";
    }
    else {
      XMLData += "        <middleName></middleName>\n";
    }


    XMLData += "        <lastName>" + customer.getName().getLastName() + "</lastName>\n";
    XMLData += "      </name>\n";
    XMLData += "      <email>\n";
    XMLData += "        <username>" + customer.getEmail().getUser() + "</username>\n";
    XMLData += "        <host>" + customer.getEmail().getHost() + "</host>\n";
    XMLData += "        <domain>" + customer.getEmail().getDomain() + "</domain>\n";
    XMLData += "      </email>\n";
    XMLData += "      <phone>\n";
    XMLData += "        <countryCode>" + customer.getPhone().getCountryCode() + "</countryCode>\n";
    XMLData += "        <number>" + customer.getPhone().getPhoneNumber() + "</number>\n";
    XMLData += "      </phone>\n";

    if(!customer.isPrivate()){
      XMLData += "      <customerCompany>\n";
      XMLData += "        <name>" + customer.getCompany().getName() + "</name>\n";
      XMLData += "        <CVR>" + customer.getCompany().getCVR() + "</CVR>\n";
      XMLData += "      </customerCompany>\n";
    }

    XMLData += "    </customer>";

    return XMLData;
  }

  public static Customer read(ArrayList<String> XMLData){
    boolean isPrivate = Boolean.parseBoolean(XMLData.get(1).replace("<isPrivate>", "").replace("</isPrivate>", "").trim());
    String firstName = XMLData.get(3).replace("<firstName>", "").replace("</firstName>", "").trim();
    String middleName = XMLData.get(4).replace("<middleName>", "").replace("</middleName>", "").trim();
    String lastName = XMLData.get(5).replace("<lastName>", "").replace("</lastName>", "").trim();
    String username = XMLData.get(8).replace("<username>", "").replace("</username>", "").trim();
    String host = XMLData.get(9).replace("<host>", "").replace("</host>", "").trim();
    String domain = XMLData.get(10).replace("<domain>", "").replace("</domain>", "").trim();
    String countryCode = XMLData.get(13).replace("<countryCode>", "").replace("</countryCode>", "").trim();
    String number = XMLData.get(14).replace("<number>", "").replace("</number>", "").trim();

    Name name = new Name(firstName, middleName, lastName);
    Email email = new Email(username, host, domain);
    Phone phone = new Phone(countryCode, number);
    if(!isPrivate){
      String companyName = XMLData.get(17).replace("<name>", "").replace("</name>", "").trim();
      int CVR = Integer.parseInt(XMLData.get(18).replace("<CVR>", "").replace("</CVR>", "").trim());
      CustomerCompany company = new CustomerCompany(companyName, CVR);
      return new Customer(name, phone, email, company);
    }
    else{
      return new Customer(name, phone, email);
    }
  }
}
