package java04;

import java.util.Scanner;

public class upper {
    
    public static void main(String[] args){
        
        Scanner keyin = new Scanner(System.in);
        
        char chr;
        
        System.out.print("문자를 입력 : ");
        chr = keyin.next().charAt(0);
        
        System.out.println("ch : "+chr);
        
        if(chr>='a'&&chr<='z'){
            System.out.println("ch to UpperCase : " +Character.toUpperCase(chr));
            
        } else if (chr>='A'&&chr<='Z'){
            System.out.println("ch to LowerCase : " +Character.toLowerCase(chr));
            
        }
    }
    
}
