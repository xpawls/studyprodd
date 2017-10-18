package java14.st11excercise;

public class Point {
    private int x = 0;
    private int y = 0;
    
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
    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        System.out.println("point 생성자");
    }
    public Point() {
        super();
        System.out.println("point 생성자");
        // TODO Auto-generated constructor stub
    }
    
    
}
