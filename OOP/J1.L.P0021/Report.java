

public class Report {
    
    private String id;
    private String studentName;
    private String courseName;
    private int totalCourse;

    public Report() {}

    public Report(String id,String studentName, String courseName, int totalCourse) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public void setId(String id) {this.id = id;}     
    public void setStudentName(String studentName) {this.studentName = studentName;}
    public void setCourseName(String courseName) {this.courseName = courseName;}
    public void setTotalCourse(int totalCourse) {this.totalCourse = totalCourse;}

    public String getId() {return id;}        
    public String getStudentName() {return studentName.toUpperCase();}
    public String getCourseName() {return courseName.toUpperCase();}
    public int getTotalCourse() {return totalCourse;}
    
}
