
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Fruit> lf = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        
        int option;
        do {            
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping(for buyer)");
            System.out.println("4. Exit");
            System.out.print("Select a option: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Re-enter:");
            }
        } while (true);
    }
}
