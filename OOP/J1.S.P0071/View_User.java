
import java.text.ParseException;
import java.util.Scanner;

public class View_User {

    Scanner sc = new Scanner(System.in);
    Controller c;
    Validation vl = new Validation();

    public View_User(Controller c) {
        this.c = c;
    }

    public void Add_Task() throws ParseException {
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            Task t = new Task();

            t.setID(c.get_ID());
            System.out.println("ID: " + t.getID());
            System.out.print("Enter Task TypeID: ");
            t.setTaskTypeID(vl.checkInput_TaskTypeId());
            System.out.print("Enter Requirement Name: ");
            t.setRequirementName(vl.checkInput_String());
            System.out.print("Enter Date(dd-MM-yyyy): ");
            t.setDate(vl.checkInputDate());
            System.out.print("Plan From: ");
            t.setPlanFrom(vl.Input_PlanFrom());
            System.out.print("Plan To: ");
            t.setPlanTo(vl.Input_PlanTo(t.getPlanFrom()));
            System.out.print("Enter Assignee: ");
            t.setAssignee(vl.checkInput_String());
            System.out.print("Enter Reviewer: ");
            t.setReviewer(vl.checkInput_String());
            if(c.Check_Duplicate_Task(t.getTaskTypeID(),t.getRequirementName(), t.getDate(),
                t.getPlanFrom(), t.getPlanTo(), t.getAssignee(), t.getReviewer()) == false){
                c.add(t.getTaskTypeID(), t.getRequirementName(), t.getDate(), t.getPlanFrom(), t.getPlanTo(), t.getAssignee(), t.getReviewer());
                System.out.println("Do you want to continue adding task(Yes-Y or No-N)");
                ans = vl.Ans_Add();
            }
            else
                System.err.println("Task was existed,Re-enter: ");            
        }
    }

    public void Delete_Task() {
        if (c.List_Task().isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            int id = 0;
            System.out.print("Enter ID of task want delete:");
            while (c.Existance_ID(id) == -1) {
                id = vl.checkInput_Int();
                if (c.Existance_ID(id) == -1) {
                    System.err.print("Not exist,Re_enter:");
                }
            }
            c.deleteTask(id);
            System.out.println("Delete successful....");
        }
    }

    public void Update_Task() throws ParseException {
        if (c.List_Task().isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            int id = 0;
            String RequirementName, TaskTypeID, Date,PlanFrom, PlanTo, Assignee, Reviewer;

            System.out.print("Enter ID of task want update:");
            while (c.Existance_ID(id) == -1) {
                id = vl.checkInput_Int();
                if (c.Existance_ID(id) == -1) {
                    System.err.print("Not exist,Re_enter:");
                }
            }
            System.out.println("----------------------Information before update----------------------");
            System.out.printf("%-3s  %-15s  %-10s  %-10s  %-9s  %-8s  %-9s  %-8s\n",
                    "ID", "Name", "Task Type", "Date", "Plan From","Plan To", "Assignee", "Reviewer");
            System.out.printf("%-3s  %-15s  %-10s  %-10s  %-9s  %-8s  %-9s  %-8s\n",
                    c.obj(id).getID(), c.obj(id).getRequirementName(), c.obj(id).getTaskTypeID(), c.obj(id).getDate(),
                     c.obj(id).getPlanFrom(),c.obj(id).getPlanTo() , c.obj(id).getAssignee(), c.obj(id).getReviewer());

            System.out.print("Enter new Task Type ID:");
            TaskTypeID = vl.Input_TaskTypeIdForUpdate();
            if(!TaskTypeID.equalsIgnoreCase("Nope"))
                c.obj(id).setTaskTypeID(TaskTypeID);

            System.out.print("Enter new Requirement Name: ");
            RequirementName = vl.checkInput_String();
            if (!RequirementName.equalsIgnoreCase("Nope")) {
                c.obj(id).setRequirementName(RequirementName);
            }

            System.out.print("Enter new Date(dd-MM-yyyy): ");
            Date = vl.Input_Date_Update();
            if (!Date.equalsIgnoreCase("Nope")) {
                c.obj(id).setDate(Date);
            }
            
            
            System.out.print("Plan From: ");
            PlanFrom = vl.Input_PlanFromForUpdate();
            if(!PlanFrom.equalsIgnoreCase("Nope"))
                c.obj(id).setPlanFrom(Double.parseDouble(PlanFrom));
            
            if(c.obj(id).getPlanFrom() >= c.obj(id).getPlanTo()){
                System.out.print("Plan To: ");
                c.obj(id).setPlanTo(vl.Input_PlanTo(c.obj(id).getPlanFrom()));
            }               
            else{
                System.out.print("Plan To: ");
                PlanTo = vl.Input_PlanToForUpdate(c.obj(id).getPlanFrom());
                if(!PlanTo.equalsIgnoreCase("Nope"))
                    c.obj(id).setPlanTo(Double.parseDouble(PlanTo));
            }
            
            System.out.print("Enter new Assignee: ");
            Assignee = vl.checkInput_String();
            if (!Assignee.equalsIgnoreCase("Nope")) {
                c.obj(id).setAssignee(Assignee);
            }

            System.out.print("Enter new Reviewer: ");
            Reviewer = vl.checkInput_String();
            if (!Reviewer.equalsIgnoreCase("Nope")) {
                c.obj(id).setReviewer(Reviewer);
            }

            System.out.println("Update Succesful....");
        }
    }

    public void Show_Task() {
        if (c.List_Task().isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            c.Show_TaskDescendingByID();
            System.out.printf("%-3s  %-15s  %-10s  %-10s  %-5s  %-8s  %-7s\n",
                    "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for (Task List1 : c.List_Task()) {
                System.out.printf("%-3s  %-15s  %-10s  %-10s  %-5.2f  %-8s  %-7s\n",
                        List1.getID(), List1.getRequirementName(), List1.getTaskTypeID(), List1.getDate(),
                        List1.getPlanTo() - List1.getPlanFrom(), List1.getAssignee(), List1.getReviewer());
            }
        }
    }

}
