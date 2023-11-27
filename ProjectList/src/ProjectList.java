import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ProjectList {
    private final List<Project> projects;
    private final Set<Integer> usedIDs;
    private final Random random;

    public ProjectList() {
        projects = new ArrayList<>();
        usedIDs = new HashSet<>();
        random = new Random();
    }

    public void addProject(Project project) {
        int projectId = generateUniqueID();
        project.setProjectID(projectId);
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    private int generateUniqueID() {
        int projectId;
        do {
            projectId = generatePseudoRandomID();
        } while (usedIDs.contains(projectId));

        usedIDs.add(projectId);
        return projectId;
    }

    private int generatePseudoRandomID() {
        return random.nextInt(Integer.MAX_VALUE); // This line of code generates a pseudo-random ID
    }
}
