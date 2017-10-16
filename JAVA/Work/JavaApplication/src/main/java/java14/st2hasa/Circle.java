package java14.st2hasa;

public class Circle {
    private int radiun = 0;
    private Point center ;
    public int getRadiun() {
        return radiun;
    }
    public void setRadiun(int radiun) {
        this.radiun = radiun;
    }
    public Point getCenter() {
        return center;
    }
    public void setCenter(Point center) {
        this.center = center;
    }
    public Circle(int radiun, Point center) {
        super();
        this.radiun = radiun;
        this.center = center;
    }
    public Circle() {
        super();
    }
    @Override
    public String toString() {
        return "Circle [radiun=" + radiun + ", center=" + center + "]";
    }
    
    
}
