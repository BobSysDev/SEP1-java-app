package model;

import java.util.Comparator;

/**
 * ProjectIDComparator class compares Project objects based on their project IDs.
 * It implements the Comparator interface for comparing projects by their unique identifiers.
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 */
public class ProjectIDComparator implements Comparator<Project>
{

  /**
   * Compares two Project objects based on their project IDs.
   *
   * @param o1 the first Project object to compare
   * @param o2 the second Project object to compare
   * @return an integer value representing the comparison result:
   *         - 0 if the project IDs of both projects are equal.
   *         - a positive value if the project ID of o1 is greater than the project ID of o2.
   *         - a negative value if the project ID of o1 is less than the project ID of o2.
   */
  @Override public int compare(Project o1, Project o2)
  {
    return Integer.compare(o1.getProjectID(), o2.getProjectID());
  }
}
