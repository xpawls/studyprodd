package java19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex19_ArrayList {
    public static void main(String [] args){
        
        Scanner key = new Scanner(System.in);
        
        List<Integer> list = null;
        list = new ArrayList<>();
        System.out.println("학생수를 입력해 주세요 :");
        
        int size = key.nextInt();
        int sum = 0;
        for(int i=0; i<size; i++){
            System.out.print("성적을 입력해 주세요: ");
            list.add(i, key.nextInt());
            sum += list.get(i);
            
        }
        int avg = sum/size;
        
        System.out.printf("학생 %d명의 평균은 %d 입니다.", size, avg);
        
        
    }
    
}
