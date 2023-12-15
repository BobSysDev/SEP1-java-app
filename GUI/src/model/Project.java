package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *The Project class represents a base class for construction projects.
 *It includes attributes and methods common to all project types.
 *This class is abstract and serves as a foundation for specific project types.
 *
 * @author Marius Gafton
 * @version 1.0 - December 2023
 */

public abstract class Project implements Serializable, Comparable<Project> {
    private static final Set<Integer> usedIDs = new HashSet<>();

    private String title;
    private double budget;
    private double budgetEstimate;
    private int timeInterval;
    private int timeEstimate;
    private double manHours;
    private double manHoursEstimate;
    private int projectID;
    private boolean isArchived;
    private String details;
    private String materials;
    private Customer customer;
    private String startDate;
    private String photoPathForWebsite;


    /**
     * Constructs a Project object with specified parameters.
     * Initializes the attributes of the Project object based on the provided parameters
     *
     * @param title            The title of the project.
     * @param budget           The actual budget allocated for the project.
     * @param budgetEstimate   The estimated budget for the project.
     * @param timeInterval     The time interval (duration) for the project.
     * @param timeEstimate     The estimated time for the project.
     * @param manHours         The actual man-hours spent on the project.
     * @param manHoursEstimate The estimated man-hours for the project.
     * @param projectID        The unique identifier for the project.
     * @param isArchived       A boolean indicating if the project is archived or active.
     * @param details          Details or description of the project.
     * @param materials        Materials used or required for the project.
     * @param startDate        The start date of the project.
     * @param customer         The customer associated with the project.
     */


    // Constructor for the Project class
    public Project(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, String startDate, Customer customer) {
        this.title = title;
        this.budget = budget;
        this.budgetEstimate = budgetEstimate;
        this.timeInterval = timeInterval;
        this.manHours = manHours;
        this.timeEstimate = timeEstimate;
        this.manHoursEstimate = manHoursEstimate;
        this.isArchived = isArchived;
        this.details = details;
        this.materials = materials;
        this.customer = customer;
        this.startDate = startDate;
        this.projectID = projectID;
        photoPathForWebsite = "";
    }


    public String getPhotoPathForWebsite() {
        return photoPathForWebsite;
    }

    public void setPhotoPathForWebsite(String photoPathForWebsite) {
        this.photoPathForWebsite = photoPathForWebsite;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    //Setters and Getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudgetEstimate() {
        return budgetEstimate;
    }

    public void setBudgetEstimate(double budgetEstimate) {
        this.budgetEstimate = budgetEstimate;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public double getManHours() {
        return manHours;
    }

    public void setManHours(double manHours) {
        this.manHours = manHours;
    }

    public int getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(int timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public double getManHoursEstimate() {
        return manHoursEstimate;
    }

    public void setManHoursEstimate(double manHoursEstimate) {
        this.manHoursEstimate = manHoursEstimate;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }


    public abstract String getType();

    /**
     * Compares this Project's title with another Project's title for ordering purposes.
     *
     * @param o The Project object to be compared with this Project.
     * @return A negative integer, zero, or a positive integer as this Project's title
     *         is less than, equal to, or greater than the specified Project's title.
     * @author Marius Gafton
     * @version 1.0 - December 2023
     */
     @Override public int compareTo(Project o)
    {
        return this.getTitle().compareTo(o.getTitle());
    }

    /**
     * Indicates whether some other object is "equal to" this one by comparing their attributes.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the o argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return Double.compare(project.budget, budget) == 0 &&
                Double.compare(project.budgetEstimate, budgetEstimate) == 0 &&
                timeInterval == project.timeInterval &&
                timeEstimate == project.timeEstimate &&
                Double.compare(project.manHours, manHours) == 0 &&
                Double.compare(project.manHoursEstimate, manHoursEstimate) == 0 &&
                projectID == project.projectID &&
                isArchived == project.isArchived &&
                Objects.equals(title, project.title) &&
                Objects.equals(details, project.details) &&
                Objects.equals(materials, project.materials) &&
                Objects.equals(customer, project.customer);
    }

}


