package java02;

import java.util.Scanner;

public class 예제3_25 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char ch = ' ';
        
        System.out.printf("문자를 하나 입력하세요.>");
        
        String input = scanner.nextLine();
        ch = input.charAt(0);
        
        if('0' <= ch && ch <= '9'){ // ASCII - 48~57
            System.out.printf("입력하신 문자는 숫자입니다.%n");
            
        }
        if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) { // ASCII 97~122 || ASCII 65~90
            System.out.printf("입력하신 문자는 영문자입니다.%n");
        }
    }//main
    
}
