package model;

import java.io.Serializable;
import java.util.Objects;

public class IndustrialProject extends Project implements Serializable {

    double size;
    String intendedUse;

    // Constructor for the IndustrialProject class
    public IndustrialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, String intendedUse,String startDate, Customer customer){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials, startDate, customer);
        this.size = size;
        this.intendedUse = intendedUse;

    }

    //Setters and Getters
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return "Industrial";
    }

    public void setIntendedUse(String intendedUse) {
        this.intendedUse = intendedUse;
    }
    public String getIntendedUse(){
        return intendedUse;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndustrialProject that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.size, size) == 0 &&
                Objects.equals(that.intendedUse, intendedUse);
    }
}