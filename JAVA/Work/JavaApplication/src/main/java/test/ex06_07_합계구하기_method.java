package test;

import java.util.Scanner;

public class ex06_07_합계구하기_method {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int x, y, sum=0;
        
        System.out.println("시작값을 입력 : ");   x= key.nextInt();
        System.out.println("종료값을 입력 : ");   y= key.nextInt();
        
        if(x>y){
            int tmp =x;
            x = y;
            y = tmp;
        }
        sum = sum(x, y);
        
        print(x, y, sum);
        
        
    }
    
    public static int sum(int x, int y){
        int sum = 0;
        for(int i=x ; i<=y; i++){
            sum += i;
        }
        return sum;
    }
    
    public static void print(int x, int y, int sum){
        System.out.println("================================");
        System.out.printf("%d 부터 %d 까지의 합은 %d입니다.\n", x, y, sum);
        System.out.println("================================");
    }
}
