package java14.stexemployee;

public class EmployeeTest {
    public static void main(String[] args){
        Manager m = new Manager();
        Manager m2 = new Manager("aaa", "bbb", 600, "ccc", 20);
        System.out.println(m.salary);
        m.test();
        m2.test();
    }
}
