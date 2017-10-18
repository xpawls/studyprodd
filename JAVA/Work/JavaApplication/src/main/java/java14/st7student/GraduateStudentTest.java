package java14.st7student;

public class GraduateStudentTest {
    public static void main(String[] args){
        GraduateStudent g1 = new GraduateStudent();
        GraduateStudent g2 = new GraduateStudent();
        GraduateStudent g3 = new GraduateStudent(003, "goat", "777-4362", "next");
        
        g1.setNumber(001);
        g1.name = "ancor";
        g1.phone = "999-9999";
        g1.lab = "aksdie";
        
        g2.setNumber(002);
        g2.setName("sse");
        g2.setPhone("888-9192");
        g2.setLab("besides");
        
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        
    }
}
