package model;

import java.util.Comparator;

/**
 * ProjectDateComparator class compares Project objects based on their start dates.
 * It implements the Comparator interface for comparing projects by their start dates.
 * Date format: dd.mm.yyyy
 *
 * It compares two Project objects by their start dates in chronological order.
 * It takes the project start dates and checks them based on the day, month, and year to compare.
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 */
public class ProjectDateComparator implements Comparator<Project>
{

  /**
   * Compares two Project objects based on their start dates.
   *
   * @param o1 the first Project object to compare
   * @param o2 the second Project object to compare
   * @return an integer value representing the comparison result:
   *         - 0 if the start dates of both projects are equal.
   *         - a positive value if the start date of o1 is later than the start date of o2.
   *         - a negative value if the start date of o1 is earlier than the start date of o2.
   */

  @Override public int compare(Project o1, Project o2)
  {
    int[] date1 = new int[3];
    int[] date2 = new int[3];

    int i = 0;
    for(String num : o1.getStartDate().split("\\.")){
      date1[i] = Integer.parseInt(num);
      i++;
    }

    i = 0;
    for(String num : o2.getStartDate().split("\\.")){
      date2[i] = Integer.parseInt(num);
      i++;
    }

    if(date1[2] == date2[2]){
      if(date1[1] == date2[1]){
        return Integer.compare(date1[0], date2[0]);
      }
      return Integer.compare(date1[1], date2[1]);
    }
    return Integer.compare(date1[2], date2[2]);
  }
}
