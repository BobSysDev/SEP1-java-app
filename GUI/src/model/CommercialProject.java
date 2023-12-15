package model;

import java.io.Serializable;
import java.util.Objects;


/**
 * CommercialProject class represents a specific type of commercial construction project.
 * It extends the Project class and includes attributes and functionalities specific to commercial projects.
 *
 * @author Marius Gafton
 * @version 1.0 - December 2023
 */
public class CommercialProject extends Project implements Serializable {

    double size;
    String intendedUse;
    int numberOfFloors;


    /**
     * Constructs a CommercialProject with specified attributes.
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
     * @param size              Size of the commercial project.
     * @param intendedUse       Intended use of the commercial project.
     * @param numberOfFloors    Number of floors in the commercial project.
     * @param startDate         Start date of the project.
     * @param customer          Customer associated with the project.
     *
     */


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

    /**
     * Indicates whether some other object is "equal to" this one by comparing their attributes, ncluding the attributes specific to CommercialProject.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the o argument; {@code false} otherwise.
     */
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