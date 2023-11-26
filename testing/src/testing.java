public class testing {
    public static void main(String[] args) {
      // Creating multiple projects
      for (int i = 0; i < 1; i++) {
        Project newProject = new Project(
                "Project " + (i + 1),
                10000.0,
                12000.0,
                30,
                40,
                250.0,
                300.0,
                0,
                false,
                "Project details",
                "Project materials"
        );
          System.out.println("Project Title: " + newProject.getTitle());
          System.out.println("Project ID: " + newProject.getProjectID());
          System.out.println("Budget: " + newProject.getBudget());
          System.out.println("Budget Estimate: " + newProject.getBudgetEstimate());
          System.out.println("Time Interval: " + newProject.getTimeInterval());
          System.out.println("Time Estimate: " + newProject.getTimeEstimate());
          System.out.println("Man Hours: " + newProject.getManHours());
          System.out.println("Man Hours Estimate: " + newProject.getManHoursEstimate());
          System.out.println("Is Archived? " + newProject.isArchived());
          System.out.println("Details: " + newProject.getDetails());
          System.out.println("Materials: " + newProject.getMaterials());

          // Displaying the maximum ID value
          System.out.println("Maximum ID Value: " + Project.getMaxIdValue());
      }
    }
  }



