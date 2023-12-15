package model;

import java.io.IOException;

/**
 * Main interface which is connected to the GUI part of the project.
 * Initializing methods used in the GUI part of the project.
 * Methods are described in ConstructionCompanyManager.
 *
 * @author Samuel Knieza
 * @version 1.0 - December 2023
 */
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

  public String getPathForWebsiteRoot();
  public String readPathForWebsiteRoot();
  boolean Confirmation(String s, String s1);
  void reconstructDataBaseFromXML() throws IOException;
  void importProjectsFromXML() throws IOException;
  void setPathForWebsiteRoot(String path);
}