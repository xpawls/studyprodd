package java04;

import java.util.Scanner;

public class ex04_21_무한입력 {
    
    public static void main(String[] args){
        
        Scanner keyboard =new Scanner(System.in);
        
        for(int i=0; true; i=i+1){
            System.out.print("정수를 입력하세요 : ");
            i= keyboard.nextInt();
            
            if(i<=0){
                break;
            } else {
                System.out.println("입력한 값은 "+i+"입니다.");
            }
        }
        
        System.out.println("정상 종료합니다.");
    }
}
