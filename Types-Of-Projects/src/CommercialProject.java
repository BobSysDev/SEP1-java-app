import java.io.Serializable;

public class CommercialProject extends Project implements Serializable {

    double size;
    String type;

    // Constructor for the CommercialProject class
    public CommercialProject(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, double size, String type, String startDate, Customer customer){
        super(title, budget, budgetEstimate, timeInterval, timeEstimate, manHours, manHoursEstimate, projectID, isArchived, details, materials, startDate, customer);
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

    @Override public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}