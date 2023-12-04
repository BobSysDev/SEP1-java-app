import java.util.Comparator;

public class ProjectBudgetComparator implements Comparator<Project>
{
  @Override public int compare(Project o1, Project o2)
  {
    return Double.compare(o1.getBudget(), o2.getBudget());
  }
}
