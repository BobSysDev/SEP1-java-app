package model;

import java.io.Serializable;

public class IndustrialProject extends Project implements Serializable {

    double size;
    String type;

    // Constructor for the IndustrialProject class
    public IndustrialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, String type){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials);
        this.size = size;
        this.type = type;

    }

    //Setters and Getters
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}