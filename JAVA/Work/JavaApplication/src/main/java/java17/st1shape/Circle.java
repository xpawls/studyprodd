package java17.st1shape;

public class Circle extends Shape {
    public int radius;
    
    public Shape getShape(){
        return null;
        
    }
    
    public void draw(){
        System.out.println("원 그림");
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", toString()=" + super.toString()
                + "]";
    }

    public Circle(String color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
        System.out.println("Circle(String color, int x, int y, int radius)");
    }

    public Circle(int radius) {
        super();
        this.radius = radius;
        System.out.println("Circle(int radius)");
    }

    public Circle() {
        super();
        System.out.println("Circle()");
        // TODO Auto-generated constructor stub
    }

    public Circle(String color, int x, int y) {
        super(color, x, y);
        System.out.println("Circle(String color, int x, int y)");
        // TODO Auto-generated constructor stub
    }
    
    
}
