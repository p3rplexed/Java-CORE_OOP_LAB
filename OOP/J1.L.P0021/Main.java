
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();       
        Validation val = new Validation();
        Controller_Methods c = new Controller_Methods(list);
        View_User v = new View_User(c);
        
        list.add(new Student("A1", "Ha Van A", "1", "C/C++"));
        list.add(new Student("A2", "Ha Van B", "2", "Java"));
        list.add(new Student("A3", "Ha Van C", "3", ".Net"));
        list.add(new Student("A4", "Ha Van D", "1", "Java"));
        list.add(new Student("A5", "Ha Van E", "2", "C/C++"));
        list.add(new Student("A6", "Ha Van F", "3", ".Net"));
        
        int option;
        do {
            System.out.println("---------------------------");
            System.out.println("1.Add:");
            System.out.println("2.Find by name and Sort:");
            System.out.println("3.Update/Delete :");
            System.out.println("4.Report :");
            System.out.println("0.Exit Program:");
            System.out.println("----------------------------");
            System.out.print("Select a option:");
            option = val.Check_int();
            switch(option)
            {
                case 1:
                    v.Add_Student();break;
                case 2:
                    v.Find_By_Name();break;
                case 3:                         
                    v.Update_Or_Delete();break;                                                                                                                               
                case 4:
                    v.Report();break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("This function is not available,Re_select!!!");                    
            }
        } while (true);
        
    }
}

