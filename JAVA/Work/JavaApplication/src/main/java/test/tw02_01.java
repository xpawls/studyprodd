package test;

import java.util.Scanner;

public class tw02_01 {
    
    public static void main(String[] args){
        
        double w = 5;
        int h = 10;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("가로 : ");
        w = keyboard.nextDouble();
        System.out.println("세로 : ");
        h = keyboard.nextInt();
        
        int area = (int)w*h;
        int perimeter = 2*((int)w+h);
        
        System.out.printf("사각형의 넓이 : %d%n", area);
        System.out.printf("사각형의 둘레 : %d", perimeter);
    }
    
}
