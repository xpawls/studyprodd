package java04;

import java.util.Scanner;

public class ex04_14_무한구구단간소화 {
    
    public static void main(String[] args){
        
        Scanner keybo = new Scanner(System.in);
        
        int sum  = 0;
        int temp = 0;
        
        for(int p = 1; true ; p=p+1){
            System.out.print("시작단을 입력 : ");
            int i= keybo.nextInt();
            System.out.print("종료단을 입력 : ");
            int j = keybo.nextInt();
            
            if(i==0 || j==0){
                break;
            }
            
            if(i>=j){
                temp=   i;
                i   =   j;
                j   =temp;
                
               
            } else if (i<j) {
               
                }
            for(int x=i; x<=j; x=x+1){
                for(int y=1; y<=9; y=y+1){
                    sum= x*y;
                    System.out.printf(" %d x %d = %d ", x,y,sum);
                }
                System.out.println();
            } 
            
        }
    }
}

