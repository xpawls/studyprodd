package java03;

import java.util.Scanner;

public class ex03_02_MaxNumber {
    public static void main(String[] args){
        
        // 메인 메서드 만들기
        
            // 정수 변수 2개 만들기 : x,y
        
            // 키보드와 프로그램 연결
            
            // 첫번째 키보드에서 입력 받은 값을 x에 넣는다.
            // 두번째 키보드에서 입력 받은 값을 y에 넣는다.
        
            // x가 y보다 크다면 x : 7 이라고 출력
            // x가 y보다 작다면 y : 7 이라고 출력

        Scanner keyboard = new Scanner(System.in);
        System.out.print("x 의 값을 입력 : ");       
        int x = keyboard.nextInt();
        
        System.out.print("y 의 값을 입력 : ");
        int y = keyboard.nextInt();
        
        System.out.print("z 의 값을 입력 : ");
        int z = keyboard.nextInt();
        
        if( x > y && x > z ){
            System.out.printf("입력 받은 수중 가장 큰 수는 %d 입니다",x);
        } else if ( y > x && y > z){
            System.out.printf("입력 받은 수중 가장 큰 수는 %d 입니다",y);
        } else {
            System.out.printf("입력 받은 수중 가장 큰 수는 %d 입니다",z);
        }

    }
    
}
