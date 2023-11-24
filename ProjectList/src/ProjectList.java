import java.util.ArrayList;
import java.util.List;



public class ProjectList {
    private List<Project> projects;

    public ProjectList() {
        projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

   public void removeProject(Project project) {
       projects.remove(project);
   }

    public List<Project> getProjects() {
        return projects;
    }

}
