package java03;

import java.util.Scanner;

public class jv03_03_중첩ifelse {
    
    public static void main(String[] args){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("점수를 입력하세요 : ");
        
        int score = keyboard.nextInt();
        
        System.out.println("점수는 " + score + "점 입니다.");
        
        if( score >= 90 ){
            System.out.println("A");
        } else {
            if( score >= 80 ){
                System.out.println("B");                
            } else { 
                if( score >= 70){
                    System.out.println("C");
                } else {
                    if( score >= 60 ){
                        System.out.println("D");
                    } else {
                        System.out.println("F");
                    }
                }
                
            }
        }
    }
    
}
