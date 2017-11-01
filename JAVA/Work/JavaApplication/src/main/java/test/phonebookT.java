package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class phonebookT {
    
    public static void main(String[] args) {
        Scanner ke = new Scanner(System.in);
        int select = 0;
        String name ;
        String pn;
        String bir;
        Map<String, PhoneInfo> pm = new HashMap<>();
        for(;;){
            int i = 0;
            System.out.println("선택하세요...");
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 검색");
            System.out.println("3. 데이터 삭제");
            System.out.println("4. 프로그램 종료");
            System.out.print("선택 : ");  select = ke.nextInt();
            
            if(select==1){
                
                
                System.out.print("이름 : ");     name = ke.next();
                System.out.print("전화번호 : "); pn = ke.next();
                System.out.print("생년월일 : "); bir = ke.next();
                pm.put(name, new PhoneInfo(name, pn, bir));
                
                i++;
                
            } else if (select==2){
                System.out.println("종료합니다.");
                break;
            }
        }
        
    }
    
}
