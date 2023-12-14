package model;

import java.io.Serializable;

/**
 * ResidentialProject class represents a specific type of construction project focusing on residential properties.
 * It extends the Project class and adds attributes and functionalities specific to residential projects.
 *
 *
 *@author Marius Gafton
 *@version 1.0 - December 2023
 */
public class ResidentialProject extends Project implements Serializable {

    private double size;
    private int numberOfKitchens;
    private int numberOfBathrooms;
    private int otherRoomsWithPlumbing;
    private boolean isNewBuild;

    /**
     * Constructs a ResidentialProject with specified attributes.
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
     * @param size                    Size of the residential property.
     * @param numberOfKitchens        Number of kitchens in the property.
     * @param numberOfBathrooms       Number of bathrooms in the property.
     * @param otherRoomsWithPlumbing  Number of additional rooms with plumbing.
     * @param isNewBuild              Indicates if it's a new build or existing property.
     * @param startDate               Start date of the project.
     * @param customer                Customer associated with the project.
     *
     */


    // Constructor for the ResidentialProject class
    public ResidentialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, int numberOfKitchens, int numberOfBathrooms, int otherRoomsWithPlumbing, boolean isNewBuild, String startDate, Customer customer){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials, startDate, customer);
        this.size = size;
        this.numberOfKitchens = numberOfKitchens;
        this.numberOfBathrooms = numberOfBathrooms;
        this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
        this.isNewBuild = isNewBuild;
    }

    //Setters and Getters
    public double getSize(){
        return size;
    }

    @Override public String getType()
    {
        return "Residential";
    }

    public void setSize(double size){
        this.size = size;
    }

    public int getNumberOfKitchens(){
        return numberOfKitchens;
    }

    public void setNumberOfKitchens(int numberOfKitchens){
        this.numberOfKitchens = numberOfKitchens;
    }

    public int getNumberOfBathrooms(){
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms){
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getOtherRoomsWithPlumbing(){
        return otherRoomsWithPlumbing;
    }

    public void setOtherRoomsWithPlumbing(int otherRoomsWithPlumbing){
        this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
    }

    public boolean isNewBuild(){
        return isNewBuild;
    }

    public void setNewBuild(boolean isNewBuild){
        this.isNewBuild = isNewBuild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResidentialProject that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.size, size) == 0 &&
                numberOfKitchens == that.numberOfKitchens &&
                numberOfBathrooms == that.numberOfBathrooms &&
                otherRoomsWithPlumbing == that.otherRoomsWithPlumbing &&
                isNewBuild == that.isNewBuild;
    }
}

