package test;

import java.util.Scanner;

public class jv07_03_반평균구하기 {
    
    public static void main(String[] args) {
        int size = 0;
        int sum = 0;
        double avg = 0;
        Scanner key = new Scanner(System.in);
        System.out.print("학생수를 입력하세요. : ");
        size = key.nextInt();
        
        int[] std = new int[size];
        for(int i=0; i<std.length;i++){
            System.out.print("성적을 입력하시요. :");
            std[i] = key.nextInt();
            sum += std[i];
        }
        System.out.println("합계는 : " +sum);
        avg = (double)sum/size;
        
        System.out.println("평균은 : " +avg);
        
    }
    
}
