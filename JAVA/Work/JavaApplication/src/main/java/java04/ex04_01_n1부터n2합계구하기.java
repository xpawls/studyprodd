package java04;

import java.util.Scanner;

public class ex04_01_n1부터n2합계구하기 {
    
    public static void main(String [] args){
        
        int n1 = 0;
        int n2 = 0;
        int sum = 0;
        int temp = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("정수를 입력하세요. ");
        n1 = keyboard.nextInt();
        n2 = keyboard.nextInt();
        
        if(n1>=n2){
            
            for(int i=n1 ; i>=n2 ; i=i-1){
                sum = sum+i;
                if(i>n2){
                    System.out.print(i+"+");
                } else {
                    System.out.print(i+ " = "+ sum);
                }
                
            }
        } else {
            temp=n1;
            n1=n2;
            n2=temp;
            for(int i=n2 ; i<=n1 ; i=i+1){
                sum = sum+i;
                if(i<n1){
                    System.out.print(i+"+");
                } else {
                    System.out.print(i+ " = "+ sum);
                }
            }
            
        }
    }
    
}