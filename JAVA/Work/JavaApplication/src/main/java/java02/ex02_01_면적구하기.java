package java02;

import java.util.Scanner;

public class ex02_01_면적구하기 {
    
    public static void main(String[] args){
        
        int w = 0;
        int h = 0;
        int area = 0;
        int perimeter = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("w의 값을 입력 : ");
        w = keyboard.nextInt();
        System.out.print("h의 값을 입력 : ");
        h = keyboard.nextInt();
        
        area = w*h;
        perimeter = 2*(w+h);
        
        System.out.println("사각형의 넓이 : " + area);
        System.out.println("사각형의 둘레 : " + perimeter);
        
    }
    
}
