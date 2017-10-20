package java17.st1shape;

public class Rectangle extends Shape {
    public int width;
    public int height;
    
    public Shape getShape(){
        return null;
        
    }
    
    public void draw(){
        System.out.println("사각형 그림");
    }

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

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height
                + ", toString()=" + super.toString() + "]";
    }

    public Rectangle(String color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
        System.out.println("Rectangle(String color, int x, int y, int width, int height)");
    }
    
    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        System.out.println("Rectangle(int width, int height)");
    }

    public Rectangle() {
        super();
        System.out.println("Rectangle()");
        // TODO Auto-generated constructor stub
    }

    public Rectangle(String color, int x, int y) {
        super(color, x, y);
        // TODO Auto-generated constructor stub
        System.out.println("Rectangle(String color, int x, int y)");
    }

    
    
    
}
