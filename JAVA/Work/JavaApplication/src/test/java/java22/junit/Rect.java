package java22.junit;

public class Rect {
    private int width = 0;
    private int height = 0;
    
    public int area(){
        return this.height*this.width;
    }
    
    public int perimeter(){
        return 2*(this.height+this.width);
    }
    
    public Object type(){
        return null;
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

    public Rect(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rect() {
        super();
    }
    
    
}
