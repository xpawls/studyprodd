package java06;

import java.util.Scanner;

public class ex06_03_isNumber {
    
    public static boolean isNumber(String st){
        
        if(st==null||st==""){
            return false;
        } else {
            return true;
        }
        
    }
    
    
    public static void main(String[] args){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("문자열 입력");
        String s = keyboard.next();
        
        
        
        boolean b = isNumber(s);
        
        System.out.println(b);
        
    }
}//재확인 요망
