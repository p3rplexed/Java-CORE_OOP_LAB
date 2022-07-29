
import java.io.IOException;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        
        Validation val = new Validation();
        View_User user = new View_User();
        
        int option;
        do {
            System.out.println("------------------------------");
            System.out.println("1.Add employees");
            System.out.println("2.Update employees");
            System.out.println("3.Remove employees");
            System.out.println("4.Search employees");
            System.out.println("5.Sort employees by salary");
            System.out.println("6.Exit");
            System.out.println("------------------------------");
            System.out.print("Select a option: ");
            option = val.Input_Int();
            switch(option){
                case 1:
                    user.Add();break;
                case 2:
                    user.Update();break;
                case 3:
                    user.Remove();break;
                case 4:
                    user.Search();break;
                case 5:
                    user.Sort();break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Re-enter(1->6): ");
            }
        } while (true);
        
    }
    
    
}
