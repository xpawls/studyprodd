package java14.st11excercise;

public class Circle extends Shape {
    private int radiuse = 0;
    // get set
    public int getRadiuse() {
        return radiuse;
    }

    public void setRadiuse(int radiuse) {
        this.radiuse = radiuse;
    }
    // constructor
    public Circle(String color, Point pt, int radiuse) {
        super(color, pt);
        this.radiuse = radiuse;
        System.out.println("color, pt, radiuse 생성자 Circle" );
    }

    public Circle(int radiuse) {
        super();
        this.radiuse = radiuse;
        System.out.println("rediuse 생성자 Circle");
    }

    public Circle() {
        super();
        System.out.println("기본생성자Circle");
    }

    public Circle(String color, Point pt) {
        super(color, pt);
        System.out.println("color, pt 생성자 Circle");
    }
    // toString
    @Override
    public String toString() {
        return "Circle [radiuse=" + radiuse + ", toString()=" + super.toString()
                + "]";
    }
    
    
}
