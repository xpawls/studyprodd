package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListEx {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("학생수를 입력하시오 : ");
        
        int size = key.nextInt();
        int sum = 0;
        double avg = 0;
        List<Integer> al = new ArrayList<>();
        
        for(int i=0; i<size; i++){
            System.out.print("성적을 입력하시오. : ");
            al.add(i, key.nextInt());
            sum += al.get(i);
        }
        
        System.out.println("합계는 : " +sum);
        avg = (double)sum/size;
        System.out.println("평균은 : " +avg);
        
    }
    
}
