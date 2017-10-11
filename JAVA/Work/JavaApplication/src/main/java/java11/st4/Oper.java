package java11.st4;

public class Oper {
    
    private int x;
    private int y;
    
    int Add(){
        return x+y;
    }
    
    int Minus(){
        return x-y;
    }
    
    int Mul(){
        return x*y;
    }
    
    double Div(){
        return (double)(x/y);
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

    public Oper() {
        super();
    }
    
}
