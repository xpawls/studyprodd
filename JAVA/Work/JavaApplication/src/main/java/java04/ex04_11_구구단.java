package java04;

import java.util.Scanner;

public class ex04_11_구구단 {
    
    public static void main(String[] args){
        
        int sum = 0;
        int tmp = 0;
        
        Scanner key = new Scanner(System.in);
        System.out.print("시작 단수를 입력하세요 : ");
        int x = key.nextInt();
        
        System.out.print("종료 단수를 입력하세요 : ");
        int y = key.nextInt();
        
        
        if(x<=y){
            for(int i=x; i<=y; i=i+1){
                for(int j=1; j<=9; j=j+1){
                    
                    sum = i*j;
                    
                    if(j<9){
                        System.out.printf("%2d x %d = %3d, ", i,j,sum);
                    } else {
                        System.out.printf("%2d x %d = %3d. ", i,j,sum);
                    }
                }
                System.out.println();
            }
        } else {
            
            tmp = x;
            x   = y;
            y   = tmp;
            
            for(int i=x; i<=y; i=i+1){
                for(int j=1; j<=9; j=j+1){
                    
                    sum = i*j;
                    
                    if(j<9){
                        System.out.printf("%2d x %d = %3d, ", i,j,sum);
                    } else {
                        System.out.printf("%2d x %d = %3d. ", i,j,sum);
                    }
                }
                System.out.println();
            }
        }
    }
}
