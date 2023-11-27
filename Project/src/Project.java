
import java.io.Serializable;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;


public class Project implements Serializable {
    private static final Set<Integer> usedIDs = new HashSet<>();
    private String title;
    private double budget;
    private double budgetEstimate;
    private int timeInterval;
    private int timeEstimate;
    private double manHours;
    private double manHoursEstimate;
    private int projectID;
    private boolean isArchived;
    private String details;
    private String materials;

    // Constructor for the Project class
    public Project(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials) {
        this.title = title;
        this.budget = budget;
        this.budgetEstimate = budgetEstimate;
        this.timeInterval = timeInterval;
        this.manHours = manHours;
        this.timeEstimate = timeEstimate;
//        this.projectID = generateProjectID();
        this.manHoursEstimate = manHoursEstimate;
        this.isArchived = isArchived;
        this.details = details;
        this.materials = materials;
    }



//    private int generateProjectID() {
//        Random random = new Random(); //Creates a new Random object for generating random numbers
//        int newID; // Declaration of a variable to hold the new project ID
//        do {
//            newID = random.nextInt(MAX_ID_VALUE - 1) + 1; // Generates a random integer ID within MAX_ID_VALUE = 100000, and it generates IDs from 1 to MAX_ID_VALUE - 1
//        } while (usedIDs.contains(newID)); //Loop continues if the generated ID is already in use
//        usedIDs.add(newID);  // Adds the generated IDs to the set of used IDs
//        return newID;
//    }

    //Setters and Getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudgetEstimate() {
        return budgetEstimate;
    }

    public void setBudgetEstimate(int budgetEstimate) {
        this.budgetEstimate = budgetEstimate;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public double getManHours() {
        return manHours;
    }

    public void setManHours(double manHours) {
        this.manHours = manHours;
    }

    public int getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(int timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public double getManHoursEstimate() {
        return manHoursEstimate;
    }

    public void setManHoursEstimate(double manHoursEstimate) {
        this.manHoursEstimate = manHoursEstimate;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }


}


