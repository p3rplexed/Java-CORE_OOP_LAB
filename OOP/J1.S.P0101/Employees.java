
public class Employees {
    private String ID;
    private String First_Name;
    private String Last_Name;
    private String Phone;
    private String Email;
    private String Address;
    private String DOB;
    private String Sex;
    private double Salary;
    private String Agency;
    
    //constructor default
    public Employees(){}

    //initialize value for data fields from outside the class
    public Employees(String ID, String First_Name, String Last_Name, String Phone, String Email, String Address,String DOB, String Sex, double Salary, String Egency) {
        this.ID = ID;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DOB = DOB;
        this.Sex = Sex;
        this.Salary = Salary;
        this.Agency = Egency;
    }
    
    //methods setter,assign value for data fields from outside the class
    public void setID(String ID) {this.ID = ID;}
    public void setFirst_Name(String First_Name) {this.First_Name = First_Name;}
    public void setLast_Name(String Last_Name) {this.Last_Name = Last_Name;}
    public void setPhone(String Phone) {this.Phone = Phone;}
    public void setEmail(String Email) {this.Email = Email;}
    public void setAddress(String Address) {this.Address = Address;}
    public void setDOB(String DOB) {this.DOB = DOB;}  
    public void setSex(String Sex) {this.Sex = Sex;}
    public void setSalary(double Salary) {this.Salary = Salary;}
    public void setAgency(String Agency) {this.Agency = Agency;}

    //methods getter,take value of data fields from outside the class
    public String getID() {return ID;}
    public String getFirst_Name() {return First_Name.trim();}
    public String getLast_Name() {return Last_Name.trim();}
    public String getPhone() {return Phone;}
    public String getEmail() {return Email.trim();}
    public String getAddress() {return Address.trim();}
    public String getDOB() {return DOB;}   
    public String getSex() {return Sex;}
    public double getSalary() {return Salary;}
    public String getAgency() {return Agency;}
    
   
}
