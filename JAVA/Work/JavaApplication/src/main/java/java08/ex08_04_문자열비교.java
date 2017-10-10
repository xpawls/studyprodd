package java08;

import java.util.Scanner;

public class ex08_04_문자열비교 {
    public static void main(String[] args){
        
        String str1 = "";
        String str2 = "";
        
        Scanner keybo = new Scanner(System.in);
        System.out.print("Please input first string : ");
        str1 = keybo.next();
        System.out.print("Please input second string : ");
        str2 = keybo.next();
        
        if(str1.equals(str2)){
            System.out.println("same");
        } else {
            System.out.println("defferent");
            
        }
        if(str1 == str2){
            System.out.println("same");
        } else {
            System.out.println("defferent");
            
        }
    }
}
