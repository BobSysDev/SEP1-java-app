package model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * The ProjectList class represents a collection of Project objects.
 * It manages the addition, retrieval, and removal of projects within the list.
 * This class also generates unique project IDs and handles project-related functionalities.
 *
 * @author Marius Gafton
 * @version 1.0 - December 2023
 */
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

    /**
     * Adds a Project to the list without checking for the ID uniqueness.
     * This method is specifically intended for use when reading projects from a file.
     * It adds the provided Project to the list and adjusts the project counter for unique IDs.
     *
     * @param project The Project object to be added to the list.
     * @version 1.0 - December 202
     */
    public void addProjectAndBypassIdCheck(Project project) {
        projects.add(project);
        // Adjusts project counter for unique IDs based on the added project's ID
        if(project.getProjectID() >= projectCounter) {
            projectCounter = project.getProjectID() + 1;
            System.out.println("Next free project ID: " + projectCounter);
        }
    }

    public int getSize(){
        return projects.size();
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


    /**
     * Generates a unique project ID based on the project counter.
     * This method increments the project counter to ensure a unique ID is produced each time it's called.
     *
     * @version 1.0 - December 202
     * @return A String representing a unique project ID.
     */
    private String generateUniqueID() {
        String uniqueID = String.valueOf(projectCounter);
        projectCounter++;
        return uniqueID;
    }
}
