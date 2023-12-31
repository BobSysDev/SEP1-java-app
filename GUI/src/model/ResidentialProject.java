package model;

import java.io.Serializable;

public class ResidentialProject extends Project implements Serializable {

    private double size;
    private int numberOfKitchens;
    private int numberOfBathrooms;
    private int otherRoomsWithPlumbing;
    private boolean isNewBuild;
    private String type;

    // Constructor for the ResidentialProject class
    public ResidentialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, int numberOfKitchens, int numberOfBathrooms, int otherRoomsWithPlumbing, boolean isNewBuild, String type,String startDate, Customer customer){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials, startDate, customer);
        this.size = size;
        this.numberOfKitchens = numberOfKitchens;
        this.numberOfBathrooms = numberOfBathrooms;
        this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
        this.isNewBuild = isNewBuild;
        this.type = type;
    }

    //Setters and Getters
    public double getSize(){
        return size;
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

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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



}

