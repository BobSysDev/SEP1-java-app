package model;

import java.io.*;

/**
 * Class for reading and writing binary files for CustomerList and ProjectList
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 * @see "ConstructionCompanyFile interface"
 */

public class BinaryReaderWriter implements ConstructionCompanyFile
{
  /**
   * Reads CustomerList from the specified binary file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @return CustomerList object
   * @throws IOException if file could not be found or accessed
   */
  @Override public CustomerList readCustomerList(String path)
      throws IOException
  {
    File file = new File(path);
    CustomerList retrievedList;
    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
      retrievedList = (CustomerList) in.readObject();
    }
    catch (ClassNotFoundException e){
      retrievedList = null;
    }

    return retrievedList;
  }

  /**
   * Writes CustomerList to the specified binary file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @param customerList CustomerList object to be written
   * @throws IOException if file could not be found or accessed
   */
  @Override public void writeCustomerList(String path,
      CustomerList customerList) throws IOException
  {
    File file = new File(path);

    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
      out.writeObject(customerList);
    }
  }

  /**
   * Reads ProjectList from the specified binary file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @return ProjectList object
   * @throws IOException if file could not be found or accessed
   */
  @Override public ProjectList readProjectList(String path) throws IOException
  {
    File file = new File(path);
    ProjectList retrievedList;

    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
      retrievedList = (ProjectList) in.readObject();
    }
    catch (ClassNotFoundException e){
      retrievedList = null;
    }

    return retrievedList;
  }

  /**
   * Writes ProjectList to the specified binary file
   *
   * @param path String, path to the file. Can be relative or absolute
   * @param projectList ProjectList object to be written
   * @throws IOException if file could not be found or accessed
   */
  @Override public void writeProjectList(String path, ProjectList projectList)
      throws IOException
  {
    File file = new File(path);

    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
      out.writeObject(projectList);
    }
  }
}
