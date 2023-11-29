import java.io.FileNotFoundException;
import java.io.IOException;

public interface ConstructionCompanyFile
{
  public CustomerList readCustomerList(String path)
      throws IOException;
  public void writeCustomerList (String path, CustomerList customerList)
      throws IOException;

  public ProjectList readProjectList(String path) throws IOException;
  public void writeProjectList(String path, ProjectList projectList)
      throws IOException;
}
