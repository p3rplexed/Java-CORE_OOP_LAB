
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);
    Controller c = new Controller();

    //check limit select of type task (1-4)
    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.print("Re-enter(only enter digit " + min + "->" + max + "): ");
            }
        }
    }

    //check input integer
    public int checkInput_Int() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
                System.err.print("Incorect Format,Re-enter: ");
            }
        }
    }

    //check input type Date
    public String Validatation_Date(String result) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(result);
            String temp[] = result.split("-");
            int year = Integer.parseInt(temp[2]);
            if (!result.equalsIgnoreCase(format.format(date)) && year < 2022) {
                System.err.print("Invalid(dd-MM-yyyy): ");
            } else {
                return result;
            }          
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.out.print("Re-enter: ");
        }
        return null;
    }
        
    //check input type Date
    public String checkInputDate() throws ParseException {
        while (true) {
            String result = sc.nextLine().trim();
            if(Validatation_Date(result) != null)
                return result;
        }
    }

    //check input type Date
    public String Input_Date_Update() throws ParseException {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Nope")) {
                return result;
            }
            if(Validatation_Date(result) != null)
                return result;
        }
    }

    //check input String,enter only letter,digit
    public String checkInput_String() {
        while (true) {
            String result = sc.nextLine();
            if (result.matches("^[a-zA-Z0-9\\s]+$")) {
                return result;
            } else {
                System.err.println("In-valid(only letter ,digit and space)!!!");
                System.out.print("Re-enter: ");
            }
        }
    }

    //check input double
    public double checkInput_Double() {
        double result;
        while (true) {
            try {
                result = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
                System.out.print("Re-enter: ");
                continue;
            }
            break;
        }
        return result;
    }

    //the time start task
    public double Input_PlanFrom() {
        double input;
        while (true) {
            input = checkInput_Double();
            if (input >= 8 && input <= 17 && input % 0.5 == 0) {
                break;
            } else {
                System.err.print("Re-enter(8->17 && 8.0, 8.5, 9.0,...): ");
            }
        }
        return input;
    }

    //the time start task use for update if enter "Nope" -> don't update
    public String Input_PlanFromForUpdate() {
        String input;
        while (true) {
            input = sc.nextLine();
            if(input.equalsIgnoreCase("Nope"))
                return input;
            try {                
                double temp = Double.parseDouble(input);
                if (temp >= 8 && temp <= 17 && temp % 0.5 == 0) {
                    return input;
                } else {
                    System.err.print("Re-enter(8->17 && 8.0, 8.5, 9.0,...): ");
                }            
            } catch (Exception e) {
                System.err.print("Re-enter(or enter Nope -> don't update): ");
            }           
        }
    }
    
    //the time end task
    public double Input_PlanTo(Double Input_PlanFrom) {
        double input;
        while (true) {
            input = checkInput_Double();
            if (input > Input_PlanFrom && input <= 17.5 && input % 0.5 == 0) {
                return input;
            } else {
                System.err.print("Re-enter(> Plan From and <= 17.5 && 8.0, 8.5, 9.0,...): ");
            }
        }
    }

    //the time end task use for updateif enter "Nope" -> don't update
    public String Input_PlanToForUpdate(Double Input_PlanFrom) {
        String input;
        while (true) {
            input = sc.nextLine();
            if(input.equalsIgnoreCase("Nope"))
                return input;
            try {                
                double temp = Double.parseDouble(input);
                if (temp > Input_PlanFrom && temp <= 17.5 && temp % 0.5 == 0) {
                    return input;
                } else {
                    System.err.print("Re-enter(Input_PlanFrom->17.5 && 8.0, 8.5, 9.0,...): ");
                }            
            } catch (Exception e) {
                System.err.print("Re-enter(or enter Nope -> don't update): ");
            }           
        }
    }
    
    //return type of task
    public String checkInput_TaskTypeId() {
        String result = null;
        while (true) {
            int n = checkIntLimit(1, 4);
            switch (n) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Manager";
                    break;
                case 4:
                    result = "Learn";
            }
            return result;
        }
    }

    //return type of task (1->) if enter "Nope" -> don't update
    public String Input_TaskTypeIdForUpdate() {
        String result;
        while (true) {
            result = sc.nextLine();
            if (result.equals("1")) {
                result = "Code";
                break;
            } else if (result.equals("2")) {
                result = "Test";
                break;
            } else if (result.equals("3")) {
                result = "Manager";
                break;
            } else if (result.equals("4")) {
                result = "Learn";
                break;
            } else if (result.equalsIgnoreCase("Nope")) {
                break;
            } else {
                System.err.print("Re-enter(1->4 or Nope->don't update):");
            }
        }
        return result;
    }

    //method check answer for add,enter only Y or N
    public String Ans_Add() {
        String a;
        while (true) {
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

}
