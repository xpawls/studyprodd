package java20.st4phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestPhone {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int select = 0;
        Map<String, Phone> map = new HashMap<>();
        String name, addr, number;
        
        for(;;){
            System.out.print("삽입:0. 삭제:1, 찾기:2, 전체보기:3, 종료:4>>>");
            select = key.nextInt();
            if(select==0){//삽입
                System.out.print("이름>>");   name = key.next();
                if(map.get(name)!=null){
                    System.out.println("이미 있습니다.");
                    break;
                }
                System.out.print("주소>>");   addr = key.next();
                System.out.print("전화번호>>"); number = key.next();
                map.put(name, new Phone(addr, number));
            } else if(select==1) {//삭제
                System.out.print("이름>>");   name = key.next();
                
                map.remove(name);
            } else if(select==2) {//찾기
                
            } else if(select==3) {//전체보기
                
            } else if(select==4) {//종료
                break;
            } else {//잘못된값입력
                System.out.println("잘못된 값을 입력");
                continue;
            }
        }
        
    }
    
}
