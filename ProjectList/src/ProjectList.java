import java.util.ArrayList;
import java.util.List;



public class ProjectList {
    private List<Project> projects;

    // Constructor - Initializes the projects list using an ArrayList
    public ProjectList() {
        projects = new ArrayList<>();
    }

    // Method to add a Project to the list
    public void addProject(Project project) {
        projects.add(project);
    }

    // Method to remove a Project to the list
   public void removeProject(Project project) {
       projects.remove(project);
   }

    public List<Project> getProjects() {
        return projects;
    }

}
