package java04;

import java.util.Scanner;

public class ex04_14_무한구구단 {
    
    public static void main(String[] args){
        
        Scanner keybo = new Scanner(System.in);
        
        int sum  = 0;
        
        
        for(int i = 1; true ; i=i+1){
            System.out.print("시작단을 입력 : ");
            i= keybo.nextInt();
            System.out.print("종료단을 입력 : ");
            int j = keybo.nextInt();
            
            if(i==0 || j==0){
                break;
            }
            
            if(i>=j){
                
                
                for(int x=j; x<=i; x=x+1){
                    for(int y=1; y<=9; y=y+1){
                        sum= x*y;
                        System.out.printf(" %d x %d = %d ", x,y,sum);
                    }
                    System.out.println();
                }
            } else if (i<j) {
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
}

