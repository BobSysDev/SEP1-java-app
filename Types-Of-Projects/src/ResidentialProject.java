public class ResidentialProject extends Project{

    double size;
    int numberOfKitchens;
    int numberOfBathrooms;
    int otherRoomsWithPlumbing;
    boolean isNewBuild;

    public ResidentialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, int manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, int numberOfKitchens, int numberOfBathrooms, int otherRoomsWithPlumbing, boolean isNewBuild){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials);
        this.size = size;
        this.numberOfKitchens = numberOfKitchens;
        this.numberOfBathrooms = numberOfBathrooms;
        this.otherRoomsWithPlumbing = otherRoomsWithPlumbing;
        this.isNewBuild = isNewBuild;
    }
}