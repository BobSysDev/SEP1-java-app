import java.io.IOException;

public class FileManipulationTestsForCustomersXML
{
  public static void main(String[] args)
  {
    CustomerList customerList = new CustomerList();
    Customer customerA = new Customer(new Name("John", "Doe"), new Phone("45", "12345678"), new Email("johndoe", "gmail", "com"));
    Customer customerB = new Customer(new Name("Mark", "Stone"), new Phone("48", "123456789"), new Email("markstone", "totallylegitcompany", "net"), new CustomerCompany("Totally Legit Company", 213769420));

    customerList.addCustomer(customerA);
    customerList.addCustomer(customerB);

    XMLReaderWriter xmlFileInterface = new XMLReaderWriter();
    try
    {
      xmlFileInterface.writeCustomerList("customerDB.xml", customerList);
      System.out.println("Writing complete");
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while writing. Check the parameters. Printout: " + e);
    }

    CustomerList retrievedCustomerList = new CustomerList();

    try{
      retrievedCustomerList = xmlFileInterface.readCustomerList("customerDB.xml");
      System.out.println("Reading complete");
    }
    catch (IOException e){
      System.out.println("ERROR: IOException has occurred while reading. Check the parameters. Printout: " + e);
    }


    System.out.println("Information retrieved. Displaying...");
    System.out.println("==========================\nTest 1 of 2: Customer 1\n");
    System.out.println(retrievedCustomerList.getCustomer(0).isPrivate());
    System.out.println(retrievedCustomerList.getCustomer(0).getName().getFullName());
    System.out.println(retrievedCustomerList.getCustomer(0).getName().getFullName().equals(customerList.getCustomer(0).getName().getFullName()));
    System.out.println(retrievedCustomerList.getCustomer(0).getEmail().getFullEmail());
    System.out.println(retrievedCustomerList.getCustomer(0).getEmail().getFullEmail().equals(customerList.getCustomer(0).getEmail().getFullEmail()));
    System.out.println(retrievedCustomerList.getCustomer(0).getPhone().getFullPhoneNumber());
    System.out.println(retrievedCustomerList.getCustomer(0).getPhone().getFullPhoneNumber().equals(customerList.getCustomer(0).getPhone().getFullPhoneNumber()));
    System.out.println("==========================\nTest 2 of 2: Customer 2\n");
    System.out.println(retrievedCustomerList.getCustomer(1).isPrivate());
    System.out.println(retrievedCustomerList.getCustomer(1).getName().getFullName());
    System.out.println(retrievedCustomerList.getCustomer(1).getName().getFullName().equals(customerList.getCustomer(1).getName().getFullName()));
    System.out.println(retrievedCustomerList.getCustomer(1).getEmail().getFullEmail());
    System.out.println(retrievedCustomerList.getCustomer(1).getEmail().getFullEmail().equals(customerList.getCustomer(1).getEmail().getFullEmail()));
    System.out.println(retrievedCustomerList.getCustomer(1).getPhone().getFullPhoneNumber());
    System.out.println(retrievedCustomerList.getCustomer(1).getPhone().getFullPhoneNumber().equals(customerList.getCustomer(1).getPhone().getFullPhoneNumber()));
    System.out.println(retrievedCustomerList.getCustomer(1).getCompany().getFullCompanyName());
    System.out.println(retrievedCustomerList.getCustomer(1).getCompany().getFullCompanyName().equals(customerList.getCustomer(1).getCompany().getFullCompanyName()));
  }
}
