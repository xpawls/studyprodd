package java14.st4shape;

public class Shape {
    // 필드
    private int x = 0;
    private int y = 0;
    private String color = "0";
    
    // getter & setter
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
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    // toString
    @Override
    public String toString() {
        return "Shape [x=" + x + ", y=" + y + ", color=" + color + "]";
    }
    
    // 생성자
    public Shape(int x, int y, String color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
        System.out.println("Shape(int x, int y, String color)");
    }
    public Shape() {
        super();
        System.out.println("Shape()");
    }
    
    
}
