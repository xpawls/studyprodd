package java06;

import java.util.Scanner;

public class ex06_03_isNumber2 {
    
    public static void main(String[] args){
        
        Scanner keybo = new Scanner(System.in);
        System.out.println("문자열 입력: ");
        String str = keybo.next();
        
        boolean is = isNumber(str);
        
        System.out.println("입력값은 "+is);
        
        
    }
    
    public static boolean isNumber(String ss){
        
        if(ss==null  ||  ss==""){
            return false;
        } else {
            return true;
        }
        
    }
    
}
