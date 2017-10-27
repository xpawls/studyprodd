package java19.st3studentmap;

import java.util.Scanner;

public class OperTest {
    
    public static void main(String[] args) {
        Oper o = new Oper();
        Scanner key = new Scanner(System.in);
        System.out.print("First num : ");
        int x = key.nextInt();
        System.out.print("Second num : ");
        int y = key.nextInt();
        
        System.out.println("Add : " + o.Add(x, y));
        System.out.println("Minus : " + o.Minus(x, y));
        System.out.println("Mul : " + o.Mul(x, y));
        System.out.println("Div : " + o.Div(x, y));
        
    }
    
}
