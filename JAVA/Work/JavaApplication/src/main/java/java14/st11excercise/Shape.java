package java14.st11excercise;

public class Shape {
    protected String color = "" ;
    protected Point pt;
    
    // get set
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Point getPt() {
        return pt;
    }
    public void setPt(Point pt) {
        this.pt = pt;
    }
    
    // constructor
    public Shape(String color, Point pt) {
        super();
        this.color = color;
        this.pt = pt;
        System.out.println("color, pt 생성자 Shape");
    }
    public Shape() {
        super();
        System.out.println("기본생성자Shape");
    }
    
    // toString
    @Override
    public String toString() {
        return "Shape [color=" + color + ", pt=" + pt + "]";
    }
    
    
}
