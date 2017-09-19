package test;

import java.util.Scanner;

public class tw01_02 {
    
    public static void main(String[] args){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("정수");
        int i = keyboard.nextInt();
        
        System.out.println("문자");
        String s = keyboard.next();
        
        System.out.println("입력한 정수는 : " + i);
        System.out.println("입력한 문자는 : " + s);
        
      
    }
    
}
