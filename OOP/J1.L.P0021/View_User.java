
import java.util.ArrayList;
import java.util.Scanner;


public class View_User {

    Validation val = new Validation();
    Controller_Methods cm ;

    public View_User(Controller_Methods cm) {
        this.cm = cm;
    }
    
    Scanner sc = new Scanner(System.in);
    
    //add
    public void Add_Student() {
        String ans_continue = "";
        
        while (!ans_continue.equalsIgnoreCase("N")) {
            Student s = new Student();

            System.out.print("Enter ID: ");
            s.setID(val.Input_String());

            if (cm.Existance_ID(s.getID()) != -1) {
                System.out.println("Enter name: " + cm.obj(s.getID()).getName());
                s.setName(cm.obj(s.getID()).getName());
                System.out.print("Enter Semester: ");
                s.setSemester(val.Input_String());
                System.out.print("Enter Course: ");              
                while(true){
                    s.setCourse_name(val.Input_Course());
                    if(!cm.Existance_Semester(s.getID(), s.getSemester(), s.getCourse_name()))
                        break;
                    else
                        System.err.print("The subject already exists this semester,Re-enter: ");
                }
                cm.Add(s);
            } else {
                System.out.print("Enter Name: ");
                s.setName(val.Input_String());
                System.out.print("Enter Semester: ");
                s.setSemester(val.Input_String());
                System.out.print("Enter Course: ");
                s.setCourse_name(val.Input_Course());

                cm.Add(s);
            }
            System.out.print("Do you want add continue( Y_Yes or N_No): ");
            ans_continue = val.Ans_Add();
            System.out.println("");
        }
    }

    //find and sort
    //search students have name contain Sequance_input
    public void Find_By_Name() {
        
        if (cm.List_Student().isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            String name;
            System.out.print("Enter name need find: ");
            name = sc.nextLine();
            
            System.out.println("-------------Search Result-------------");
            System.out.printf("%-8s  %-20s  %-10s  %-10s\n",
                "ID", "Name", "Semester", "Course"); 
            for (Student List1 : cm.Find_Sort(name)) {
                System.out.printf("%-8s  %-20s  %-10s  %-10s\n"
                ,List1.getID(),List1.getName(),List1.getSemester(),List1.getCourse_name());
            }
            
        }
    }

    //update/delete
    public void Update_Or_Delete() {
        if (cm.List_Student().isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            String ID = "";
            System.out.print("Enter ID of Student you want find: ");
            while (cm.Existance_ID(ID) == -1) {
                ID = val.Input_String();
                if (cm.Existance_ID(ID) == -1) {
                    System.err.println("ID is not exist,Re-enter:");
                }
            }
            ArrayList<Student> temp = cm.List_By_ID(ID);
            
            System.out.println("");
            System.out.printf("%-3s  %-8s  %-20s  %-10s  %-10s\n","STT",
                "ID", "Name", "Semester", "Course");                       
            for (int i = 0; i < temp.size(); i++) {
                System.out.printf("%-3s  %-8s  %-20s  %-10s  %-10s\n",i,
                    temp.get(i).getID(),temp.get(i).getName(),
                    temp.get(i).getSemester(),temp.get(i).getCourse_name());
                }
            int select;
            System.out.print("Select an element you want to edit(0->" + (temp.size() - 1 ) + "): ");
            while(true){    //check input select(only enter digit and less than cm.List_By_ID(ID).size() - 1
                select = val.Check_int();
                if(select <= temp.size() - 1)
                    break;
                else
                    System.err.println("Re-enter(0->"+ (temp.size() - 1 ) + "): ");
            }
            int Index = cm.obj(select, ID);    //return a obj in List_By_ID(ID)

            String ans;
            System.out.print("update or delete(U/D):");
            ans = val.Ans_UpOrDe();
            if(ans.equalsIgnoreCase("D")) {   //delete an obj selected object above          
                cm.List_Student().remove(Index); 
                System.out.println("Delete successfull...");
            }
            else{   //choose update               
                System.out.print("Enter new Semester: ");
                String Semester_temp = val.Input_String();
                cm.List_Student().get(Index).setSemester(Semester_temp);
                System.out.print("Enter new Course: ");
                while(true){
                    String Course_temp = val.Input_Course();
                    if(!cm.Existance_Semester(cm.List_Student().get(Index).getID(), 
                            cm.List_Student().get(Index).getSemester(), Course_temp)) {
                        cm.List_Student().get(Index).setCourse_name(Course_temp);
                        break;
                    }
                    else
                        System.err.print("The subject already exists this semester,Re-enter: ");
                    
                }
            }
        }     
    }

    //Report
    public void Report() {
        if (cm.List_Student().isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            ArrayList<Report> temp = cm.Report();
            System.out.printf("%-8s  %-20s  %-10s  %-5s\n",
                "ID", "Name", "Course", "Total");
            for (int i = 0; i < temp.size(); i++) {
                System.out.printf("%-8s  %-20s  %-10s  %-5s\n",temp.get(i).getId()
                ,temp.get(i).getStudentName(),temp.get(i).getCourseName(),temp.get(i).getTotalCourse());
            }
        }
    }
}
