public class RoadConstructionProject extends Project{

    double length;
    double width;
    int numberOfBridges;
    String obstacles;


    public RoadConstructionProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double length, double width, int numberOfBridges, String obstacles){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials);
        this.length = length;
        this.width = width;
        this.numberOfBridges = numberOfBridges;
        this.obstacles = obstacles;
    }
}
