package java14.st2hasa;

public class CircleTest {
    
    public static void main(String[] args) {
        
        
        
        Point p = new Point(25, 78);
        Circle c1 = new Circle(10, p);
        
        Circle c2 = new Circle();
        c2.setRadiun(10);
        p = new Point(25,78);
        c2.setCenter(p);
        
        Circle c3 = new Circle(10, new Point(25,78));
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
    
}
