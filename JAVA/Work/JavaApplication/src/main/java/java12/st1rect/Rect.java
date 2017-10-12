package java12.st1rect;

public class Rect {
    private int width;
    private int height;
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
    public Rect() {
        super();
    }
    
    public Rect(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }
    public int getArea(){
        return width*height;
    }
    public int getPerimeter(){
        return 2*(width+height);
    }
}
