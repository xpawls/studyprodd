package 김형남;

import java.util.Scanner;

public class ex4 {
    
    public static void main(String[] args) {
        
        Scanner ke = new Scanner(System.in);
        Oper op = new Oper();
        System.out.print("First num : ");
        op.setFirstNum(ke.nextInt());
        System.out.print("Second num : ");
        op.setSecondNum(ke.nextInt());
        
        System.out.println("Add : " + op.add());
        System.out.println("Minus : " + op.minus());
        System.out.println("Mul : " + op.mul());
        System.out.println("Div : " + op.div());
        
        
        
    }
    
}
