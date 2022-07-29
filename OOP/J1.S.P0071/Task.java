
public class Task {
    private int ID;
    private String TaskTypeID;
    private String RequirementName;
    private String Date;
    private double PlanFrom;
    private double PlanTo;
    private String Assignee;
    private String Reviewer;
    
    public Task(){}

    public Task(int ID, String TaskTypeID, String RequirementName, String Date, double PlanFrom, double PlanTo, String Assignee, String Reviewer) {
        this.ID = ID;
        this.TaskTypeID = TaskTypeID;
        this.RequirementName = RequirementName;
        this.Date = Date;
        this.PlanFrom = PlanFrom;
        this.PlanTo = PlanTo;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public void setID(int ID) {this.ID = ID;}
    public void setTaskTypeID(String TaskTypeID) {this.TaskTypeID = TaskTypeID;}
    public void setRequirementName(String RequirementName) {this.RequirementName = RequirementName;}
    public void setDate(String Date) {this.Date = Date;}
    public void setPlanFrom(double PlanFrom) {this.PlanFrom = PlanFrom;}
    public void setPlanTo(double PlanTo) {this.PlanTo = PlanTo;}
    public void setAssignee(String Assignee) {this.Assignee = Assignee;}
    public void setReviewer(String Reviewer) {this.Reviewer = Reviewer;}

    public int getID() {return ID;}
    public String getTaskTypeID() {return TaskTypeID;}
    public String getRequirementName() {return RequirementName;}
    public String getDate() {return Date;}
    public double getPlanFrom() {return PlanFrom;}
    public double getPlanTo() {return PlanTo;}
    public String getAssignee() {return Assignee;}
    public String getReviewer() {return Reviewer;}
    
    
    
}
