package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * RoadConstructionProject class represents a specific type of construction project focusing on road construction.
 * It extends the Project class and includes attributes and functionalities specific to road construction projects.
 *
 *@author Marius Gafton
 *@version 1.0 - December 2023
 */
public class RoadConstructionProject extends Project implements Serializable {

    double length;
    double width;
    int numberOfBridges;
    String obstacles;

    /**
     * Constructs a RoadConstructionProject with specified attributes.
     *
     * @param title                   Title of the project.
     * @param budget                  Total budget allocated for the project.
     * @param budgetEstimate          Estimated budget for the project.
     * @param timeInterval            Time interval for the project.
     * @param timeEstimate            Estimated time for project completion.
     * @param manHours                Man-hours spent on the project.
     * @param manHoursEstimate        Estimated man-hours for the project.
     * @param projectID               Unique identifier for the project.
     * @param isArchived              Indicates if the project is archived.
     * @param details                 Details or description of the project.
     * @param materials               Materials used for construction.
     * @param length                  Length of the road construction project.
     * @param width                   Width of the road construction project.
     * @param numberOfBridges         Number of bridges within the road construction.
     * @param obstacles               Obstacles encountered in the road construction.
     * @param startDate               Start date of the project.
     * @param customer                Customer associated with the project.
     *
     */


    // Constructor for the RoadConstructionProject class
    public RoadConstructionProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double length, double width, int numberOfBridges, String obstacles, String startDate, Customer customer){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials, startDate, customer);
        this.length = length;
        this.width = width;
        this.numberOfBridges = numberOfBridges;
        this.obstacles = obstacles;
    }

    //Setters and Getters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getNumberOfBridges() {
        return numberOfBridges;
    }

    public void setNumberOfBridges(int numberOfBridges) {
        this.numberOfBridges = numberOfBridges;
    }

    @Override public String getType() {
        return "Road";
    }

    public String getObstacles() {
        return obstacles;
    }

    public void setObstacles(String obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * Indicates whether some other object is "equal to" this one by comparing their attributes,
     * including the attributes specific to RoadConstructionProject.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the o argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoadConstructionProject project)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(project.length, length) == 0 &&
                Double.compare(project.width, width) == 0 &&
                project.numberOfBridges == numberOfBridges &&
                Objects.equals(project.obstacles, obstacles);
    }
}
