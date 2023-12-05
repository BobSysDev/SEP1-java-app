import java.util.Comparator;

public class ProjectIDComparator implements Comparator<Project>
{
  @Override public int compare(Project o1, Project o2)
  {
    return Integer.compare(o1.getProjectID(), o2.getProjectID());
  }
}
