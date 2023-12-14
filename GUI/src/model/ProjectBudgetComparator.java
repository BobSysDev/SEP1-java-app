package model;

import java.util.Comparator;

/**
 * ProjectBudgetComparator class compares Project objects based on their budgets.
 * It implements the Comparator interface for comparing projects by their allocated budgets.
 *
 * @author Aleksander Gwozdz
 * @version 1.0 - December 2023
 */

public class ProjectBudgetComparator implements Comparator<Project>
{
  /**
   * Compares two Project objects based on their budgets.
   *
   * @param o1 The first Project object to be compared.
   * @param o2 The second Project object to be compared.
   * @return An integer value:
   *         - 0 if the budgets of both projects are equal.
   *         - a positive value if the budget of the first project is greater.
   *         - a negative value if the budget of the second project is greater.
   */

  @Override public int compare(Project o1, Project o2)
  {
    return Double.compare(o1.getBudget(), o2.getBudget());
  }
}
