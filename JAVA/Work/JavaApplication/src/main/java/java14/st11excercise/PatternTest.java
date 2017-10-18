package java14.st11excercise;

public class PatternTest {
    public static void main(String[] args){
        Circle c = new Circle();
        System.out.println("------------------------------1");
        Rectangle r = new Rectangle();
        System.out.println("------------------------------2");
        Circle c2 = new Circle(0);
        System.out.println("------------------------------3");
        Circle c3 = new Circle("w", new Point(2,5));
        System.out.println("------------------------------4");
        Circle c4 = new Circle(null, new Point(2,5), 0);
        System.out.println("------------------------------5");
        Rectangle r2 = new Rectangle(0, 0);
        System.out.println("------------------------------6");
        Rectangle r3 = new Rectangle(null, new Point(2,5));
        System.out.println("------------------------------7");
        Rectangle r4 = new Rectangle(null, new Point(2,5), 0, 0);
        
        
    }
}
