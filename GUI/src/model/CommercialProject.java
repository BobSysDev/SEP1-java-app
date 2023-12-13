package model;

import java.io.Serializable;
import java.util.Objects;

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

    public String getIntendedUse() {
        return intendedUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommercialProject that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.size, size) == 0 &&
                numberOfFloors == that.numberOfFloors &&
                Objects.equals(intendedUse, that.intendedUse);
    }

}