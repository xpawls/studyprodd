package 김형남;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args){
        Scanner ke = new Scanner(System.in);
        int x, y, tmp;
        
        for(;;){
            System.out.print("시작단을 입력하십시오.(종료는 0) ");
            x = ke.nextInt();
            if(x==0){ break; }
            System.out.print("종료단을 입력하십시오.(종료는 0) ");
            y = ke.nextInt();
            if(y==0){ break; }
            if(x>y){
                tmp = x;
                x = y;
                y = tmp;
            }
            for(int i=x; i<=y; i++){
                for(int j=1; j<=9; j++){
                    print(i, j);
                }
            }
            
        }
    }
    
    public static void print(int i, int j){
        System.out.printf("%2d x %d = %3d", i,j,i*j);
        if(j<9){
           System.out.print(", ");
        } else if (j==9){
            System.out.println(". ");
        }
    }
    
}
