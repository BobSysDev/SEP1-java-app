package model;

import java.io.Serializable;

public class CommercialProject extends Project implements Serializable {

    double size;
    String intendedUse;
    int numberOfFloors;

    // Constructor for the CommercialProject class
    public CommercialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, String intendedUse, int numberOfFloors, String startDate, Customer customer){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials, startDate, customer);
        this.size = size;
        this.numberOfFloors = numberOfFloors;
        this.intendedUse = intendedUse;
    }

    //Setters and Getters
    public double getSize() {
        return size;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override public String getType() {
        return "Commercial";
    }

    public void setIntendedUse(String intendedUse) {
        this.intendedUse = intendedUse;
    }
}