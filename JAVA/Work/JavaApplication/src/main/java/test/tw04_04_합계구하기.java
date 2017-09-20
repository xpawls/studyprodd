package test;

import java.util.Scanner;

public class tw04_04_합계구하기 {
    
    public static void main(String[] args){
        
        int sum = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("시작값입력 : ");
        int x = keyboard.nextInt();
        
        System.out.print("종료값입력 : ");
        int y = keyboard.nextInt();
        
        if(x>=y){
            for(int i = y; i<=x ; i = i+1){
                sum = sum + i;
            }
        } else {
            for(int i = x; i<=y ; i = i+1){
                sum = sum + i;
            }
        }//else 끝
        System.out.println(sum);
    }
}
