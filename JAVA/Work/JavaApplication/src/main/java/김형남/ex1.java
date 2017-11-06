package 김형남;

import java.util.Scanner;

public class ex1 {
    
    public static void main(String[] args) {
        Scanner ke = new Scanner(System.in);
        System.out.print("시작값을 입력하세요. ");
        int x = ke.nextInt();
        System.out.print("종료값을 입력하세요. ");
        int y = ke.nextInt();
        int sum = 0;
        if(x>y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        
        for(int i=x; i<=y; i++){
            sum += i;
            if(i<y){
                System.out.print(i+" + ");
            } else if (i==y) {
                System.out.print(i+" = "+sum);
            }
        }
        
        
        
    }
    
}
