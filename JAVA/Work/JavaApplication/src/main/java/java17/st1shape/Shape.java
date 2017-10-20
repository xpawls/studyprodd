package java17.st1shape;

public abstract class Shape {
    protected String color;
    protected int x;
    protected int y;
    
    public abstract Shape getShape();
    
    public abstract void draw();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Shape [color=" + color + ", x=" + x + ", y=" + y + "]";
    }

    public Shape(String color, int x, int y) {
        super();
        this.color = color;
        this.x = x;
        this.y = y;
        System.out.println("Shape(String color, int x, int y)");
    }

    public Shape() {
        super();
        System.out.println("Shape()");
        // TODO Auto-generated constructor stub
    }
    
    
}
