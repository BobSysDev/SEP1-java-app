package model;

import java.io.IOException;

public interface ConstructionCompanyModel
{
  public void addProject(Project project);

  public void removeProject(Project project);

  public int listSize();

  public Project getProject(int index);

  public Project getProjectByID(int id);

  public void addCustomer(Customer customer);

  public void removeCustomer(Customer customer);

  public void readProjectsFromBinaryFile();

  public void writeProjectsToBinaryFile();

  public void readCustomersFromBinaryFile();

  public void writeCustomersToBinaryFile();

  public void writeProjectsToXMLFile();

  public String getPathForPhotosForTheWebsite();
  public String readPathForPhotosForTheWebsite();
  boolean Confirmation(String s, String s1);
  void reconstructDataBaseFromXML() throws IOException;
  void importProjectsFromXML() throws IOException;
}