package java17.st1shape;

public class ShapeTest {
    public static void main(String[] args){
        
        
        Triangle t = new Triangle();
        t.draw();
        Circle c = new Circle();
        c.draw();
        Rectangle r = new Rectangle();
        r.draw();
        System.out.println("------------");
        Triangle t2 = new Triangle(null, 0, 0, 0, 0);
        Triangle t3 = new Triangle(0, 0);
        Triangle t4 = new Triangle(null, 0, 0);
        System.out.println("------------");
        Circle c2 = new Circle(null, 0, 0, 0);
        
    }
}
