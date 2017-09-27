package java07;

import java.util.Scanner;

public class jv07_03_반평균구하기1 {
    public static void main(String[] args){
       int [] score = new int[3];
       int sum = 0;
       Scanner keybo = new Scanner(System.in);
       
       for(int i=0; i<score.length; i++){
           System.out.print("점수를 입력하시오: ");
           score[i] = keybo.nextInt();
           sum = sum + score[i];
           
       }
       System.out.print("배열의 값은 : ");
       for(int i=0; i<score.length; i++){
           System.out.print(score[i]);
           if(i==score.length-1){
               
           } else {
               System.out.print(", ");
           }
       }
       
       System.out.print("\n평균은 : "+sum/score.length);
       
       
    }
    
}
