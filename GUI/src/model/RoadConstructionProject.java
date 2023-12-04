package model;

import java.io.Serializable;

public class RoadConstructionProject extends Project implements Serializable {

    double length;
    double width;
    int numberOfBridges;
    String obstacles;

    // Constructor for the RoadConstructionProject class
    public RoadConstructionProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double length, double width, int numberOfBridges, String obstacles){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials);
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

    public String getObstacles() {
        return obstacles;
    }

    public void setObstacles(String obstacles) {
        this.obstacles = obstacles;
    }
}
