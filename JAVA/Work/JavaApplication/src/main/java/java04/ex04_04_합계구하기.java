package java04;

import java.util.Scanner;

public class ex04_04_합계구하기 {
    
    public static void main(String [] args){
        int sum = 0;

        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("시작값을 입력하세요 : ");
        int 시작값 = keyboard.nextInt();
        
        System.out.print("종료값을 입력하세요 : ");
        int 종료값 = keyboard.nextInt();
        
        System.out.printf("%d 부터 %d 까지의 합계는 ", 시작값, 종료값);
        
        if(시작값< 종료값){
            for( int i = 시작값 ; i<=종료값 ; i++){
                sum = sum + i;       
            }
            System.out.printf("%d 입니다.", sum);
        } 
        else {
            for( int j = 종료값 ; j<=시작값 ; j= j+1){
                sum = sum + j;
            }
            
            System.out.printf("%d 입니다.", sum);   

        }
        
    }
}
