import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable
{
    private ArrayList<Project> projects;
    private int projectCounter;

    public static final String PROJECT_TYPE_RESIDENTIAL = "Residential";
    public static final String PROJECT_TYPE_COMMERCIAL = "Commercial";
    public static final String PROJECT_TYPE_INDUSTRIAL = "Industrial";
    public static final String PROJECT_TYPE_ROAD = "Road";

    public ProjectList() {
        projects = new ArrayList<>();
        projectCounter = 1; // Starting counter at 1
    }

    public void addProject(Project project) {
        String projectId = generateUniqueID();
        project.setProjectID(Integer.parseInt(projectId));
        projects.add(project);
    }

    public void addProjectAndBypassIdCheck(Project project) { //This method is only to be used when reading from file [IMPORTANT]
        projects.add(project);
        if(project.getProjectID() > projectCounter) {
            projectCounter = project.getProjectID() + 1;
        }
    }

    public ArrayList<Project> getProjectsByType(String type)
        throws InvalidClassException
    {
        ArrayList<Project> projectsToReturn = new ArrayList<>();
        switch (type)
        {
            case PROJECT_TYPE_RESIDENTIAL -> {
                for (Project project : projects)
                {
                    if (project instanceof ResidentialProject)
                    {
                        projectsToReturn.add(project);
                    }
                }
            }
            case PROJECT_TYPE_COMMERCIAL -> {
                for (Project project : projects)
                {
                    if (project instanceof CommercialProject)
                    {
                        projectsToReturn.add(project);
                    }
                }
            }
            case PROJECT_TYPE_INDUSTRIAL -> {
                for (Project project : projects)
                {
                    if (project instanceof IndustrialProject)
                    {
                        projectsToReturn.add(project);
                    }
                }
            }
            case PROJECT_TYPE_ROAD -> {
                for (Project project : projects)
                {
                    if (project instanceof RoadConstructionProject)
                    {
                        projectsToReturn.add(project);
                    }
                }
            }
            default -> {
                throw new InvalidClassException("Invalid project type");
            }
        }
        return projectsToReturn;
    }

    public ArrayList<Project> getProjectsSortedByName(){
        ArrayList<Project> projectsToReturn = new ArrayList<>(projects);
        projectsToReturn.sort(new ProjectNameComparator());
        return projectsToReturn;
    }

    public ArrayList<Project> getProjectsSortedByBudget(){
        ArrayList<Project> projectsToReturn = new ArrayList<>(projects);
        projectsToReturn.sort(new ProjectBudgetComparator());
        return projectsToReturn;
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public Project getProject(int index) {
        return projects.get(index);
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    private String generateUniqueID() {
        String uniqueID = String.valueOf(projectCounter);
        projectCounter++;
        return uniqueID;
    }
}
