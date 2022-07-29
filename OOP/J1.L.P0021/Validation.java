
import java.util.Scanner;


public class Validation {

    Scanner sc = new Scanner(System.in);

    //check input string (use for ID,Course)
    public String Input_Course() {
        String Input;
        while(true){
            Input = sc.nextLine();
            if(Input.equalsIgnoreCase(".net") || Input.equalsIgnoreCase("c/c++") || Input.equalsIgnoreCase("java"))
                break;
            else
                System.err.print("Incorrect format(Java, .Net , C/C++) Re-Enter:");
        }
        return Input;
    }

    //Method check input name - enter only letter and space ,other characters will invalid
    public String Input_String() {
        String Input;        
        while(true){
            Input = sc.nextLine();
            if (Input.matches("^[a-zA-Z0-9\\s]+$") && Input.equalsIgnoreCase("0") == false) {
                break;
            } else {
                System.err.println("In-valid(only letter ,digit and space)!!!");
                System.out.print("Re-enter:");
            }
        }
        return Input;
    }

    //method check value int of input
    public int Check_int() {
        int result;
        while (true) {
            try {
                result = Integer.valueOf(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
                System.err.print("In-valid(Integer),please Re-enter!!!: ");
                continue;
            }
            break;
        }
        return result;
    }

    //method check answer for add,enter only Y or N    
    public String Ans_Add() {
        String a;
        while(true){
            a = sc.nextLine();
            if (a.matches("^[yYnN]+$")) {
                break;
            } else {
                System.err.println("Only Enter(Yes(Y) or No(N)!!!");
                System.out.print("Re-Enter: ");
            }
        }
        return a;
    }

    //method check answer update or delete,enter only U or D 
    public String Ans_UpOrDe() {
        String a = "";
        while(true){
            a = sc.nextLine();
            if (a.matches("^[uUdD]+$")) {
                break;
            } else {
                System.err.println("Only Enter(Update(U) or Delete(D)!!!");
                System.out.print("Re-Enter: ");
            }
        }
        return a;
    }


}
