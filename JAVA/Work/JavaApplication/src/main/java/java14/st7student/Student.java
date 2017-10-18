package java14.st7student;

public class Student {
    private   int   number = 0;
    public    String  name = "";
    protected String phone = "";
    
    // get set
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // constructor
    public Student(int number, String name, String phone) {
        super();
        this.number = number;
        this.name = name;
        this.phone = phone;
    }
    public Student() {
        super();
    }
    // toString
    @Override
    public String toString() {
        return "Student [number=" + number + ", name=" + name + ", phone="
                + phone + "]";
    }
    
    
}
