
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class E_Methods {

    private ArrayList<Employees> List_E = new ArrayList<>();

    //method check ID
    public int Check_ID(String ID) {
        for (int i = 0; i < List_E.size(); i++) {
            if (List_E.get(i).getID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    //return List_E
    public ArrayList<Employees> getList_E() {
        return List_E;
    }

    //return a object by ID
    public Employees obj(String ID) {
        Employees e = null;
        for (int i = 0; i < List_E.size(); i++) {
            if (ID.equalsIgnoreCase(List_E.get(i).getID())) {
                e = List_E.get(i);
            }
        }
        return e;
    }

    //method add employees
    public void add_Employees(Employees e) throws IOException {
        List_E.add(e);
    }


    //method search employees
    public ArrayList<Employees> Search_Employees(String name) {
        ArrayList<Employees> eNew = new ArrayList<>();
        name = name.toLowerCase().trim();
        if (name.isEmpty()) {
            return List_E;
        }       
        for (int i = 0; i < List_E.size(); i++) {
            String temp = (List_E.get(i).getFirst_Name() + " " + List_E.get(i).getLast_Name()).toLowerCase();
            if(name.equalsIgnoreCase(List_E.get(i).getFirst_Name()) 
                || name.equalsIgnoreCase(List_E.get(i).getLast_Name())
                || (temp.contains(name))) {
                eNew.add(List_E.get(i));
            }
        }
        return eNew;
    }
    

    //method sort employees by first name
    public ArrayList<Employees> Sort_Employees() {
        Collections.sort(List_E, new Comparator<Employees>() {
            @Override
            public int compare(Employees t, Employees t1) {
                return (int)t.getSalary() - (int)t1.getSalary();
            }
        });
        return List_E;
    }
}
