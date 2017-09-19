package test;

import java.util.Scanner;

public class tw01_03 {
    
    public static void main(String[] args){
        
        int salary = 0;
        int deposit = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("salary 입력 : ");
        salary = keyboard.nextInt();
        
        deposit = salary * 12 *10;
        
        System.out.println("10년 동안의 저축액 : " + deposit + "원");
    }
    
}
