package model;

import java.io.IOException;

/**
 * Interface for reading and writing files for CustomerList and ProjectList.
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 * @see "BinaryReaderWriter and XMLReaderWriter classes that implement this interface"
 */

public interface ConstructionCompanyFile
{
  /**
   * Reads CustomerList from the specified file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @return CustomerList object
   * @throws IOException if file could not be found or accessed
   */
  public CustomerList readCustomerList(String path)
      throws IOException;

  /**
   * Writes CustomerList to the specified file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @param customerList CustomerList object to be written
   * @throws IOException if file could not be found or accessed
   */
  public void writeCustomerList (String path, CustomerList customerList)
      throws IOException;
  /**
   * Reads ProjectList from the specified file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @return ProjectList object
   * @throws IOException if file could not be found or accessed
   */
  public ProjectList readProjectList(String path) throws IOException;

  /**
   * Writes ProjectList to the specified file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @param projectList ProjectList object to be written
   * @throws IOException if file could not be found or accessed
   */
  public void writeProjectList(String path, ProjectList projectList)
      throws IOException;
}
