//public class testing {
//    public static void main(String[] args) {
//      // Creating multiple projects
//      for (int i = 0; i < 1; i++) {
//        Project newProject = new Project(
//                "Project " + (i + 1),
//                10000.0,
//                12000.0,
//                30,
//                40,
//                250.0,
//                300.0,
//                0,
//                false,
//                "Project details",
//                "Project materials"
//        );
//          System.out.println("Project Title: " + newProject.getTitle());
//          System.out.println("Project ID: " + newProject.getProjectID());
//          System.out.println("Budget: " + newProject.getBudget());
//          System.out.println("Budget Estimate: " + newProject.getBudgetEstimate());
//          System.out.println("Time Interval: " + newProject.getTimeInterval());
//          System.out.println("Time Estimate: " + newProject.getTimeEstimate());
//          System.out.println("Man Hours: " + newProject.getManHours());
//          System.out.println("Man Hours Estimate: " + newProject.getManHoursEstimate());
//          System.out.println("Is Archived? " + newProject.isArchived());
//          System.out.println("Details: " + newProject.getDetails());
//          System.out.println("Materials: " + newProject.getMaterials());
//
//          // Displaying the maximum ID value
//          System.out.println("Maximum ID Value: " + Project.getMaxIdValue());
//      }
//    }
//  }
//
//
//

//==============================================================================================

import java.util.List;

public class testing {
  public static void main(String[] args) {
    ProjectList projectList = new ProjectList();
    projectList.addProject(new Project( "Project B", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project A", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));
    projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials")); projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials")); projectList.addProject(new Project( "Project C", 1000, 23, 30, 40, 250.0, 300.0, 0, false, "Project details", "Project materials"));


    // Displaying projects with their IDs
    List<Project> projects = projectList.getProjects();
    for (Project project : projects) {
      System.out.println("Project Title: " + project.getTitle() + ", Project ID: " + project.getProjectID());
    }
  }
}

//==============================================================================================

//public class testing {
//  public static void main(String[] args) {
//    MyDate date1 = new MyDate(15, 6, 2021);
//    System.out.println("Date 1: " + date1.getDay() + "/" + date1.getMonth() + "/" + date1.getYear());
//    MyDate date2 = new MyDate(10, 10, 2022);
//    date2.setDay(25);
//    date2.setMonth(12);
//    date2.setYear(2023);
//    System.out.println("Date 2: " + date2.getDay() + "/" + date2.getMonth() + "/" + date2.getYear());
//    int intervalInMonths = date1.getIntervalInMonths(date2);
//    System.out.println("Interval between date1 and date2 in months: " + intervalInMonths);
//    MyDate endDate = date1.estimateEndDate(300);
//    System.out.println("Estimated end date after 300 days from date1: " + endDate.getDay() + "/" + endDate.getMonth() + "/" + endDate.getYear());
//  }
//}


