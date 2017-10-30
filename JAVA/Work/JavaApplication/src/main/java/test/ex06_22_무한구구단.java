package test;

import java.util.Scanner;

public class ex06_22_무한구구단 {
    
    public static void main(String[] args) {
        int x, y;
        
        Scanner key = new Scanner(System.in);
        for(;;){
            System.out.print("시작단 입력(0입력시 종료) : ");
            x=key.nextInt();
            if(x==0){break;}
            System.out.print("종료단 입력(0입력시 종료) : ");
            y=key.nextInt();
            if(y==0){break;}
            if(x>y){
                int tmp=x;
                x=y;
                y=tmp;
            }
            gugudan(x, y);
        }
        
        
    }
    public static void gugudan(int x, int y){
        for(int i=x; i<=y; i++){
            for(int j=1; j<=9; j++){
                System.out.printf(" %3d x %d = %4d", i,j,i*j);
                if(j<9){
                    System.out.print(", ");
                } else {
                    System.out.println(". ");
                }
            }
        }
    }
    
}
