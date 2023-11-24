public class IndustrialProject extends Project{

    double size;
    String type;

    public IndustrialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, String type){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials);
        this.size = size;
        this.type = type;

    }
}