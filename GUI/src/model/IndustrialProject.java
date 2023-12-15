package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * IndustrialProject class represents a specific type of industrial construction project.
 * It extends the Project class and includes attributes and functionalities specific to industrial projects.
 *
 * @author Marius Gafton
 * @version 1.0 - December 2023
 */
public class IndustrialProject extends Project implements Serializable {

    double size;
    String intendedUse;


    /**
     * Constructs an IndustrialProject with specified attributes.
     *
     * @param title             Title of the project.
     * @param budget            Total budget allocated for the project.
     * @param budgetEstimate    Estimated budget for the project.
     * @param timeInterval      Time interval for the project.
     * @param timeEstimate      Estimated time for project completion.
     * @param manHours          Man-hours spent on the project.
     * @param manHoursEstimate  Estimated man-hours for the project.
     * @param projectID         Unique identifier for the project.
     * @param isArchived        Indicates if the project is archived.
     * @param details           Details or description of the project.
     * @param materials         Materials used for construction.
     * @param size              Size of the industrial project.
     * @param intendedUse       Intended use of the industrial project.
     * @param startDate         Start date of the project.
     * @param customer          Customer associated with the project.
     *
     */


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

    /**
     * Indicates whether some other object is "equal to" this one by comparing their attributes,
     * including the attributes specific to IndustrialProject.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the o argument; {@code false} otherwise.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndustrialProject that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.size, size) == 0 &&
                Objects.equals(that.intendedUse, intendedUse);
    }
}