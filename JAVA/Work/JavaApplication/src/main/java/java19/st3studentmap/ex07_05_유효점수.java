package java19.st3studentmap;

import java.util.Scanner;

public class ex07_05_유효점수 {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.print("심사위원의 수를 입력하시오: ");
        int size = key.nextInt();
        int sum = 0;
        int [] arr = new int[size];
        System.out.print(size + "명의 심사위원의 점수 입력: ");
        for(int i=0; i<arr.length; i++){
            System.out.print((i+1)+"번째 :");
            arr[i] = key.nextInt();
        }
        java.util.Arrays.sort(arr);
        System.out.print("유효점수 : ");
        for(int i=1; i<arr.length-1; i++){
            System.out.print(arr[i]+" ");
            sum += arr[i];
        }
        System.out.println();
        System.out.println("합계 : "+ sum);
        double avg = (double)sum/(arr.length-2);
        System.out.printf("평균 : %.2f",avg);
        
    }
    
}
