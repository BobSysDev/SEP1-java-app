package model;

import java.util.Comparator;


/**
 * ProjectNameComparator class compares Project objects based on their title.
 * It implements the Comparator interface for comparing projects by their allocated titles.
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 */
public class ProjectNameComparator implements Comparator<Project>
{

  /**
   * Compares two Project objects based on their titles.
   *
   * @param o1 the first Project object to compare
   * @param o2 the second Project object to compare
   * @return an integer value representing the comparison result:
   *         - 0 if the titles of both projects are equal.
   *         - a positive value if the title of o1 comes after the title of o2 in alphabetical order.
   *         - a negative value if the title of o1 comes before the title of o2 in alphabetical order.
   */

  @Override public int compare(Project o1, Project o2)
  {
    return o1.getTitle().compareTo(o2.getTitle());
  }
}
