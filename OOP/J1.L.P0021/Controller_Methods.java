
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller_Methods {

    private ArrayList<Student> List = new ArrayList<>();

    public Controller_Methods(ArrayList<Student> List) {
        this.List = List;
    }

    
    //check existance of ID in list
    public int Existance_ID(String ID) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    //method return object by id
    public Student obj(String id) {
        Student student = List.get(Existance_ID(id));
        return student;
    }

    public int obj(int select, String ID) {
        int Index = 0;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getID().equalsIgnoreCase(List_By_ID(ID).get(select).getID())
                    && List.get(i).getSemester().equalsIgnoreCase(List_By_ID(ID).get(select).getSemester())
                    && List.get(i).getCourse_name().equalsIgnoreCase(List_By_ID(ID).get(select).getCourse_name())) {
                Index = i;
            }
        }
        return Index;
    }

    //method check existance of a object by (id ,sesmester and Course name)
    public boolean Existance_Semester(String id, String Semester, String Course) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getID().equalsIgnoreCase(id) && List.get(i).getSemester().equalsIgnoreCase(Semester)
                    && List.get(i).getCourse_name().equalsIgnoreCase(Course)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> List_By_ID(String id) {
        ArrayList<Student> l = new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getID().equalsIgnoreCase(id)) {
                l.add(List.get(i));
            }
        }
        return l;
    }

    //return a List 
    public ArrayList<Student> List_Student() {
        return List;
    }

    public void Add(Student s) {
        List.add(s);
    }

    //Delete information for student by ID
    public void Delete(Student S_Update) {
        List.remove(Existance_ID(S_Update.getID()));
    }

    //Find (by name)and sort results
    public ArrayList<Student> Find_Sort(String name) {
        ArrayList<Student> List_new = new ArrayList();
        if (name.isEmpty()) {
            return List;
        }
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                List_new.add(List.get(i));
            }
        }
        Collections.sort(List_new, new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                if (!t.getName().equalsIgnoreCase(t1.getName())) {
                    return t.getName().compareToIgnoreCase(t1.getName());
                } else {
                    return 0;
                }
            }
        });
        return List_new;
    }

    //check existance of a object report
    public boolean Report_Existance(ArrayList<Report> lr, String id, String name,
            String course, int total) {
        for (Report report : lr) {
            if (id.equalsIgnoreCase(report.getId())
                    && name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    //Report - display all list to screen
    public ArrayList<Report> Report() {
        ArrayList<Report> lr = new ArrayList<>();
        for (int i = 0; i < List.size(); i++) {
            int total = 0;
            for (int j = 0; j < List.size(); j++) {
                if (List.get(i).getID().equalsIgnoreCase(List.get(j).getID())
                        && List.get(i).getCourse_name().equalsIgnoreCase(List.get(j).getCourse_name())) {
                    total++;
                }
            }
            if (Report_Existance(lr, List.get(i).getID(), List.get(i).getName(), List.get(i).getCourse_name(), total)) {
                lr.add(new Report(List.get(i).getID(), List.get(i).getName(), List.get(i).getCourse_name(), total));
            }
        }
        //print report
        return lr;
    }

}
