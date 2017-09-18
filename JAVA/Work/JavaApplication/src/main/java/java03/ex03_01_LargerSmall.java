package java03;

import java.util.Scanner;

public class ex03_01_LargerSmall {
    public static void main(String[] args){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("n의 값을 입력 : ");
        int n = keyboard.nextInt();
        
        if ( n >= 100 ) {
            System.out.println("large");
        } else {
            System.out.println("small");
        }
    }
    
}
