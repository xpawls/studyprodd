package java07;

import java.util.Scanner;

public class ex07_01_동적배열 {
    public static void main(String[] args){
        
        int size = 0;
        
        Scanner keybo = new Scanner(System.in);
        System.out.print("만들고자 하는 배열 크기를 입력하시오:");
        size = keybo.nextInt();
        
        int [] arr = new int[size];
        
        System.out.println("배열 크기는 : "+arr.length);
    }
    
}
