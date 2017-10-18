package java14.st7student;

public class GraduateStudent extends Student {
    public String lab = "";
    
    // get set

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }
    
    // constructor

    public GraduateStudent() {
        super();
    }

    public GraduateStudent(int number, String name, String phone) {
        super(number, name, phone);
    }

    public GraduateStudent(int number, String name, String phone, String lab) {
        super(number, name, phone);
        this.lab = lab;
    }

    public GraduateStudent(String lab) {
        super();
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "GraduateStudent [lab=" + lab + ", toString()="
                + super.toString() + "]";
    }
    
    
}
