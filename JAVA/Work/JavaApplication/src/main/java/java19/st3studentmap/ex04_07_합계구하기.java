package java19.st3studentmap;

import java.util.Scanner;

public class ex04_07_합계구하기 {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        
        int sum = 0;
        
        System.out.println("시작값을 입력하세요.");
        int x = key.nextInt();

        System.out.println("종료값을 입력하세요.");
        int y = key.nextInt();
        
        if(x>y){
            int tmp=x;
            x=y;
            y=tmp;
        }
        
        sum = sumas(sum, x, y);
        
        print(sum, x, y);
        
    }

    public static void print(int sum, int x, int y) {
        System.out.printf("%d부터 %d까지의 합계는 %d입니다.", x,y,sum);
    }

    public static int sumas(int sum, int x, int y) {
        for(int i=x; i<=y; i++){
            sum += i;
        }
        return sum;
    }
    
}
