package java04;

import java.util.Scanner;

public class ex04_04_합계구하기swap {
    
    public static void main(String[] args){
        
        int sum = 0;
        int temp = 0;
        Scanner key = new Scanner(System.in);
        System.out.print("시작값을 입력 : ");
        int 시작값 = key.nextInt();
        System.out.print("종료값을 입력 : ");
        int 종료값 = key.nextInt();
        
        if (시작값>=종료값){
            for(int i=종료값; i<=시작값; i=i+1){
                sum = sum + i;
            }
        } else {
            
            temp = 시작값;
            시작값 = 종료값;
            종료값 = temp;
            
            for(int i=종료값; i<=시작값; i=i+1){
                sum = sum + i;
            }
            
        }
        System.out.println(sum);
        
    }
    
}
