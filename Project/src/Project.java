
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class Project implements Serializable, Comparable<Project> {
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
    private Customer customer;
    private String startDate;

    // Constructor for the Project class
    public Project(String title, double budget, double budgetEstimate, int timeInterval, int timeEstimate, double manHours, double manHoursEstimate, int projectID, boolean isArchived, String details, String materials, String startDate, Customer customer) {
        this.title = title;
        this.budget = budget;
        this.budgetEstimate = budgetEstimate;
        this.timeInterval = timeInterval;
        this.manHours = manHours;
        this.timeEstimate = timeEstimate;
        this.manHoursEstimate = manHoursEstimate;
        this.isArchived = isArchived;
        this.details = details;
        this.materials = materials;
        this.customer = customer;
        this.startDate = startDate;
        this.projectID = projectID;
    }


    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

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

    public String getStartDate(){
        return startDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }


    public abstract double getSize();

    public abstract String getType();


     @Override public int compareTo(Project o)
    {
        return this.getTitle().compareTo(o.getTitle());
    }

}


