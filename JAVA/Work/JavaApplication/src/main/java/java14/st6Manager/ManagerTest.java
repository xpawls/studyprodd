package java14.st6Manager;

public class ManagerTest {
    public static void main(String[] args){
        Manager m1 = new Manager("강다니엘", "압구정", 1000000000, "94010");
        Manager m2 = new Manager();
        m1.test();
        m2.setName("dd");
        m2.setAddress("la");
        m2.salary = 5400;
        m2.setRnn("12451");
        m2.test();
        
        
        
    }
}
