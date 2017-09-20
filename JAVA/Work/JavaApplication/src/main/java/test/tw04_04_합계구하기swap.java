package test;

import java.util.Scanner;

public class tw04_04_합계구하기swap {
    
    public static void main(String[] args){
        
        int sum = 0;
        int tmp = 0;
        
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("시작값입력 : ");
        int 시작값 = keyboard.nextInt();
        
        System.out.print("종료값입력 : ");
        int 종료값 = keyboard.nextInt();
        
        if(시작값>=종료값){
            tmp    = 종료값;
            종료값 = 시작값;
            시작값 = tmp;
            for(int i = 시작값; i<=종료값 ; i = i+1){
                sum = sum + i;
            }
        } else {
            for(int i = 시작값; i<=종료값 ; i = i+1){
                sum = sum + i;
            }
        }//else 끝
        System.out.println(sum);
    }
}
