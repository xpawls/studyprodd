package java11.st4;

import java.util.Scanner;

public class OperTest {
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        Oper oper = new Oper();
        int add, min, mul;
        double div;
        System.out.print("x의 값 입력: ");
        int a = key.nextInt();
        System.out.print("y의 값 입력: ");
        int b = key.nextInt();
        
        oper.setX(a);
        oper.setY(b);
        
        
        add = oper.Add();
        min = oper.Minus();
        mul = oper.Mul();
        div = oper.Div();
        System.out.printf("Add : %d%nMinus : %d%nMul : %d%nDiv : %.2f", add,min,mul,div);
    }
}
