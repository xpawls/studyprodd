package java14.st11excercise;

public class Rectangle extends Shape {
    private int width = 0;
    private int height = 0;
    
    // get set
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    
    // constructor
    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        System.out.println("width, height 생성자 Rectangle");
    }
    public Rectangle(String color, Point pt, int width, int height) {
        super(color, pt);
        this.width = width;
        this.height = height;
        System.out.println("color, pt, width, height 생성자 Rectangle");
    }
    public Rectangle() {
        super();
        System.out.println("기본생성자Rectangle");
    }
    public Rectangle(String color, Point pt) {
        super(color, pt);
        System.out.println("color, pt 생성자 Rectangle");
    }
    
    // toString
    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height
                + ", toString()=" + super.toString() + "]";
    }
    
    
}
