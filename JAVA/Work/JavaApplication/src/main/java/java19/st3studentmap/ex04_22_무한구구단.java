package java19.st3studentmap;

import java.util.Scanner;

public class ex04_22_무한구구단 {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int x, y;
        for(;;){
            System.out.print("시작단을 입력하시오<종료는 0>: ");
            x = key.nextInt();
            if(x==0){ break;}
            System.out.print("끝단을 입력하시오<종료는 0>: ");
            y = key.nextInt();
            if(y==0){ break;}
            
            if(x>y){
                int tmp = x;
                x = y;
                y = tmp;
            }
            gugudan(x, y);
            
            
        }
        
    }

    public static void gugudan(int x, int y) {
        for(int i=x; i<=y; i++){
            for(int j=1; j<=9; j++){
                System.out.printf("%3d x %d = %d", i,j,i*j);
                if(j>=9){
                    System.out.println(". ");
                } else {
                    System.out.print(", ");
                }
            }
        }
    }
    
}
