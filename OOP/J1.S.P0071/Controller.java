
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    private ArrayList<Task> List = new ArrayList<>();

    public Controller() {}

    public Controller(ArrayList<Task> List) {
        this.List = List;
    }

    //check existance of ID in list
    public int Existance_ID(int ID) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    //return a List 
    public ArrayList<Task> List_Task() {
        return List;
    }

    //return a object with same input ID
    public Task obj(int ID) {
        Task t = null;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getID() == ID) {
                t = List.get(i);
            }
        }
        return t;
    }

    //check duplicate task(There can't be 2 Tasks with all the same information but different id)
    public boolean Check_Duplicate_Task(String TaskTypeID, String RequirementName, String Date, double PlanFrom, double PlanTo, String Assignee, String Reviewer) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getTaskTypeID().equalsIgnoreCase(TaskTypeID) && List.get(i).getRequirementName().equalsIgnoreCase(RequirementName)
                    && List.get(i).getDate().equalsIgnoreCase(Date) && List.get(i).getPlanFrom() == PlanFrom && List.get(i).getPlanTo() == PlanTo
                    && List.get(i).getAssignee().equalsIgnoreCase(Assignee) && List.get(i).getReviewer().equalsIgnoreCase(Reviewer)) {
                return true;
            }
        }
        return false;
    }

    //method add a Task into List Task
    public void add(String TaskTypeID,String RequirementName,String Date,double PlanFrom,double PlanTo,String Assigment,String Reviewer) {
        int id = input_ID();
        List.add(new Task(id, TaskTypeID, RequirementName, Date, PlanFrom, PlanTo, Assigment, Reviewer));
    }

    //take value id
    public int get_ID(){
        int id = input_ID();
        return id;
    }
    
    //contructor value for id(new id = last id in list +1)
    private int input_ID() {
        int id;
        if (List.isEmpty()) {
            id = 1;
        } else {
            id = List.get(List.size() - 1).getID() + 1;
        }
        return id;
    }

    //method delete a Task in List
    public void deleteTask(int id) {
        List.remove(Existance_ID(id));
    }
    
    public void Show_TaskDescendingByID(){
        Collections.sort(List_Task(), new Comparator<Task>() {
            @Override
            public int compare(Task t, Task t1) {
                return t1.getID() -t.getID();
            }
        });
    }

}
