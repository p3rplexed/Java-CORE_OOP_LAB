
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class View_User {

    private Validation val = new Validation();
    private E_Methods em = new E_Methods();

    public void Add() throws ParseException, IOException {
        String ans = "";
        while (!ans.equalsIgnoreCase("N")) {
            Employees e = new Employees();
            System.out.print("Enter ID: ");
            String id = "";
            while (true) {
                id = val.Input_ID();
                if (em.Check_ID(id) != -1) {
                    System.err.print("ID was existed,Re-enter: ");
                } else {
                    break;
                }
            }
            e.setID(id);

            System.out.print("Enter First Name: ");
            e.setFirst_Name(val.Input_String());
            System.out.print("Enter Last Name: ");
            e.setLast_Name(val.Input_String());
            System.out.print("Enter Phone: ");
            e.setPhone(val.Input_Phone());
            System.out.print("Enter Email: ");
            e.setEmail(val.Input_Email());
            System.out.print("Enter Address: ");
            e.setAddress(val.Input_Address());
            System.out.print("Enter DOB: ");
            e.setDOB(val.Input_Date());
            System.out.print("Enter Sex: ");
            e.setSex(val.Input_Sex());
            System.out.print("Enter Salary: ");
            e.setSalary(val.Input_double());
            System.out.print("Enter Agency: ");
            e.setAgency(val.Input_String());

            em.add_Employees(e);
            System.out.print("Do you want continue adding employees(Y-Yes or N-No)");
            ans = val.Ans_Add();
        }

    }

    //update information of 1 employee
    public void Update() throws ParseException {
        String ID;
        System.out.print("Enter ID of employee want update: ");
        while (true) {
            ID = val.Input_ID();
            if (em.Check_ID(ID) == -1) {
                System.err.print("ID is not,Re-enter: ");
            } else {
                break;
            }
        }
        int options = 0;
        do {            
            System.out.println("what are you want update?");
            System.out.println("1.  First Name");
            System.out.println("2.  Last Name");
            System.out.println("3.  Phone");
            System.out.println("4.  Email");
            System.out.println("5.  Address");
            System.out.println("6.  DOB");
            System.out.println("7.  Sex");
            System.out.println("8.  Salary");
            System.out.println("9.  Agency");
            System.out.println("10. Exit");
            System.out.println("");
            System.out.print("Select a option:");
            options = val.Input_Int();
            switch (options) {
                case 1:
                    System.out.print("Enter New First Name: ");
                    em.obj(ID).setFirst_Name(val.Input_String());
                    break;
                case 2:
                    System.out.print("Enter New Last Name: ");
                    em.obj(ID).setLast_Name(val.Input_String());
                    break;
                case 3:
                    System.out.print("Enter New Phone: ");
                    em.obj(ID).setPhone(val.Input_Phone());
                    break;
                case 4:
                    System.out.print("Enter New Email: ");
                    em.obj(ID).setEmail(val.Input_Email());
                    break;
                case 5:
                    System.out.print("Enter New Address: ");
                    em.obj(ID).setAddress(val.Input_Address());
                    break;
                case 6:
                    System.out.print("Enter New DOB: ");
                    em.obj(ID).setDOB(val.Input_Date());
                    break;
                case 7:
                    System.out.print("Enter New Sex: ");
                    em.obj(ID).setSex(val.Input_String());
                    break;
                case 8:
                    System.out.print("Enter New Salary: ");
                    em.obj(ID).setSalary(val.Input_double());
                    break;
                case 9:
                    System.out.print("Enter New Agency: ");
                    em.obj(ID).setAgency(val.Input_String());
                    break;
            }
        } while (options < 10);
    }

    public void Search() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.print("Enter name want search: ");
        input = sc.nextLine();
        ArrayList<Employees> temp = em.Search_Employees(input);
        System.out.println("Result Search:");
        System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (int i = 0; i < temp.size(); i++) {
            System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                    temp.get(i).getID(), temp.get(i).getFirst_Name(),
                    temp.get(i).getLast_Name(), temp.get(i).getPhone(),
                    temp.get(i).getEmail(), temp.get(i).getAddress(),
                    temp.get(i).getDOB(), temp.get(i).getSex(),
                    temp.get(i).getSalary(), temp.get(i).getAgency());
        }
    }

    //delete information of 1 employee
    public void Remove() {
        String ID;
        System.out.print("Enter ID of employee want delete: ");
        while (true) {
            ID = val.Input_ID();
            if (em.Check_ID(ID) == -1) {
                System.err.print("ID is not,Re-enter: ");
            } else {
                break;
            }
        }
        em.getList_E().remove(em.Check_ID(ID));
        System.out.println("Delete Successful....");
    }

    public void Sort() {
        ArrayList<Employees> temp = em.Sort_Employees();
        System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (int i = 0; i < temp.size(); i++) {
            System.out.printf("%-5s  %-10s  %-10s  %-10s  %-25s  %-20s  %-10s  %-5s  %-10s  %-10s\n",
                    temp.get(i).getID(), temp.get(i).getFirst_Name(),
                    temp.get(i).getLast_Name(), temp.get(i).getPhone(),
                    temp.get(i).getEmail(), temp.get(i).getAddress(),
                    temp.get(i).getDOB(), temp.get(i).getSex(),
                    temp.get(i).getSalary(), temp.get(i).getAgency());
        }
    }

}
