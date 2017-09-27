package java07;

import java.util.Scanner;

public class ex07_03_배열로최대최소구하기2 {
    public static void main(String[] args){
        
        int[] input = new int[10];
        int max = 0;
        int min = 0;
        int tmp = 0;
        Scanner keybo = new Scanner(System.in);
        for(int i=0; i<input.length; i++){//배열 입력
            System.out.print("input : ");
            input[i] = keybo.nextInt();
        }
        System.out.print("배열 정렬 전: ");
        print(input); // 정렬전 배열 출력
        
        
        
        min = input[0];
        for(int i=0; i<input.length; i++){//최대, 최소값
            if(input[i]>max){
                max = input[i];
            } else if (input[i]<min){
                min = input[i];
            }
        }
        
        for(int i =1; i<input.length; i++){//배열 정렬식
            for(int j=0; j<i; j++){
                if(input[i]<=input[j]){
                    tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
        System.out.print("배열 정렬 후: ");
        
        print(input);// 정렬후 배열 출력
        
        System.out.println("최대값:"+max);
        System.out.println("최소값:"+min);
    }
    
    
    public static void print(int[] result){
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]);
            if(i==result.length-1){
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
        
    }
    
    
}
