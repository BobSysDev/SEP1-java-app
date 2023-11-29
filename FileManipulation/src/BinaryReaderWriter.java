import java.io.*;

public class BinaryReaderWriter implements ConstructionCompanyFile
{
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

  @Override public void writeCustomerList(String path,
      CustomerList customerList) throws IOException
  {
    File file = new File(path);

    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
      out.writeObject(customerList);
    }
  }

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

  @Override public void writeProjectList(String path, ProjectList projectList)
      throws IOException
  {
    File file = new File(path);

    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
      out.writeObject(projectList);
    }
  }
}
