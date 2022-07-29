
public class Student {
    private String ID;
    private String Name;
    private String Semester;
    private String Course_name;
    
    public Student(){}

    public Student(String ID, String Name, String Semester, String Course_name) {
        this.ID = ID;
        this.Name = Name;
        this.Semester = Semester;
        this.Course_name = Course_name;}

    //methods setter,assign value for data fields from outside the class
    public void setID(String ID) {this.ID = ID;}
    public void setName(String Name) {this.Name = Name;}
    public void setSemester(String Semester) {this.Semester = Semester;}
    public void setCourse_name(String Course_name) {this.Course_name = Course_name;}

    //methods getter ,take value of data fields from outside class
    public String getID() {return ID;}
    public String getName() {return Name;}
    public String getSemester() {return Semester;}
    public String getCourse_name() {return Course_name;}
    
}
