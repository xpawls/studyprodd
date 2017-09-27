package java07;

import java.util.Scanner;

public class ex07_05_유효점수 {
    
    public static void main(String[] args){
        int size = 0;
        
        int sum = 0;
        double ave = 0;
        int max = 0, min = 0;
        int tmp = 0;
        
        Scanner keybo = new Scanner(System.in);
        System.out.print("심사위원의 수를 입력하시오");
        size = keybo.nextInt();
        
        int[] man = new int[size];
        for(int i=0; i<size; i++){
            System.out.print(size+"명 심사 위원의 점수 입력 : ");
            man[i] = keybo.nextInt();
        }
        
        for(int i=0; i<man.length; i++){
            for(int j=0; j<i; j++){
                if(man[i]<man[j]){
                    tmp = man[i];
                    man[i] = man[j];
                    man[j] = tmp;
                }
            }
        }
        max = man[man.length-1];
        min = man[0];
        System.out.println("최대값:"+max);
        System.out.println("최소값:"+min);
        System.out.print("유효점수:");
        for(int i=1; i<man.length-1; i++){
            System.out.print(man[i]+" ");
            sum += man[i];
        }
        System.out.println();
        ave = (double)sum/man.length;
        System.out.println("합계 : "+sum);
        System.out.printf("평균 : %.2f",ave);
    }
    
}
