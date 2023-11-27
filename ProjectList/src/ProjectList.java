import java.util.ArrayList;
import java.util.List;

public class ProjectList {
    private final List<Project> projects;
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

    public List<Project> getProjects() {
        return projects;
    }

    private String generateUniqueID() {
        String formattedId = String.format("%02d", projectCounter);
        projectCounter++;
        return formattedId;
    }
}
