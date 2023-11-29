import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable
{
    private ArrayList<Project> projects;
    private int projectCounter;

    public ProjectList() {
        projects = new ArrayList<>();
        projectCounter = 1; // Starting counter at 1
    }

    public void addProject(Project project) {
        String projectId = generateUniqueID();
        project.setProjectID(Integer.parseInt(projectId));
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public Project getProject(int index) {
        return projects.get(index);
    }

    private String generateUniqueID() {
        String uniqueID = String.valueOf(projectCounter);
        projectCounter++;
        return uniqueID;
    }
}
