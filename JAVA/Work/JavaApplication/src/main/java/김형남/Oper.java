package 김형남;

public class Oper {
    private int firstNum  = 0;
    private int secondNum = 0;
    
    public int add(){
        return firstNum + secondNum;
    }
    
    public int minus(){
        return firstNum - secondNum;
    }
    public int mul(){
        return firstNum * secondNum;
    }
    public double div(){
        return (double)firstNum / secondNum;
    }
    
    
    public int getFirstNum() {
        return firstNum;
    }
    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }
    public int getSecondNum() {
        return secondNum;
    }
    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }
    public Oper(int firstNum, int secondNum) {
        super();
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }
    public Oper() {
        super();
    }
    @Override
    public String toString() {
        return "Oper [firstNum=" + firstNum + ", secondNum=" + secondNum + "]";
    }
    
    
}
