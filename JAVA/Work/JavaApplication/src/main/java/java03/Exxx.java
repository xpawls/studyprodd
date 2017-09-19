package java03;

import java.util.Scanner;

public class Exxx {
    
    public static void main(String[] args){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("k의 값을 입력하세요. : ");
        int k = keyboard.nextInt();
        
        if(k==0){
            System.out.println("A");
        } else if(k>3) {
            System.out.println("B");
        } else {
            System.out.println("C");
        }
    }
    
}