package java22.junit;

public class Oper {
    private int x = 0;
    private int y = 0;
    
    public int Add(){
        return this.x + this.y;
    }
    
    public int Minus(){
        return this.x - this.y;
            
        }
    public int mul(){
        return this.x * this.y;
    }
    
    public double Div(){
        return (double)this.x / this.y;
    }

    @Override
    public String toString() {
        return "Oper [x=" + x + ", y=" + y + "]";
    }

    public Oper(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Oper() {
        super();
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
    
    
}
