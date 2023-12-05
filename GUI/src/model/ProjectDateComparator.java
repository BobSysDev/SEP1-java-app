package model;

import java.util.Comparator;

public class ProjectDateComparator implements Comparator<Project>
{
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
