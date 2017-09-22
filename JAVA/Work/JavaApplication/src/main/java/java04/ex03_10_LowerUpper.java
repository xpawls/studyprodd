package java04;

import java.util.Scanner;

public class ex03_10_LowerUpper {
    
    public static void main(String[] args){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("문자를 하나 입력(ex..a) : ");
        String s = keyboard.next();
        
        char c = s.charAt(0);
        
        int i = (int)c;
        
        if(i>=65 && i<=90) { 
            i = i+32;
            char ch = (char)i;
            
            System.out.println("ch to lowerCase: "+ch);
        } else if (i>=97 && i<=122) {
            i = i-32;
            char ch = (char)i;
            
            System.out.println("ch to upperCase: "+ch);
        } else {
            System.out.println("에러");
        }
        
        
    }
    
}
