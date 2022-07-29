
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
     public static void main(String[] args) throws ParseException {
        ArrayList<Task> L_task = new ArrayList<>();
        Controller c = new Controller(L_task);
        
        View_User v = new View_User(c);
        Validation val = new Validation();        
        
        L_task.add(new Task(1,"code","dev program","12-09-2018",9, 15.5, "dev", "Lead"));
        L_task.add(new Task(2,"test","dev program","11-10-2018",9, 14.5, "dev", "Lead"));
        L_task.add(new Task(3,"manager","dev program","15-06-2019",9, 17.5, "dev", "Lead"));
                    
        int option;
        do {
            System.out.println("------------------------");
            System.out.println("1.Add Task");
            System.out.println("2.Update Task");
            System.out.println("3.Delete Task");
            System.out.println("4.Display all list task");
            System.out.println("5.Exit the program");
            System.out.println("-------------------------");
            System.out.print("Choose a option:");
            option = val.checkInput_Int();
            switch (option) {
                case 1:
                    v.Add_Task();
                    break;
                case 2:
                    v.Update_Task();
                    break;
                case 3:
                    v.Delete_Task();
                    break;
                case 4:
                    v.Show_Task();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Re-Enter(1->4): ");
            }
        } while (true);

    }
}
