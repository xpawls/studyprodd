package java06;

import java.util.Scanner;

public class ex06_03_사칙연산메서드 {
    
    public static void main(String[] args){
        
        //두개의 정수를 입력 받는다. x,y에 저장
        
        int x= 0, y= 0;
        
        Scanner keyboard =new Scanner(System.in);
        System.out.print("x의 값 입력:");
        x= keyboard.nextInt();
        System.out.print("y의 값 입력:");
        y= keyboard.nextInt();
        
        
        int add = Add(x,y);
        
        int minus = Minus(x,y);
        
        int mul = Mul(x,y);
        
        double div = Div(x,y);
        
        System.out.println("x와 y의 +,-,*,/ 결과값 : "+add+","+minus+","+mul+","+div);
        
    }

    private static double Div(int i, int j) {
        // TODO Auto-generated method stub
        
        double sum = 0;
        sum = (double)i/(double)j;
        
        return sum;
    }

    private static int Mul(int i, int j) {
        // TODO Auto-generated method stub
        
        int sum = 0;
        sum = i*j;
        
        return sum;
    }

    private static int Minus(int i, int j) {
        // TODO Auto-generated method stub
        
        int sum = 0;
        sum = i-j;
        
        return sum;
    }

    private static int Add(int i, int j) {
        // TODO Auto-generated method stub
        
        int sum = 0;
        sum = i+j;
        
        return sum;
    }
    
}
