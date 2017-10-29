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
                if(map.containsKey(name)==true){
                    System.out.println("이미 있습니다.");
                    continue;
                }
                System.out.print("주소>>");   addr = key.next();
                System.out.print("전화번호>>"); number = key.next();
                map.put(name, new Phone(addr, number));
                
            } else if(select==1) {//삭제
                System.out.print("삭제할 이름>>");   name = key.next();
                if(map.containsKey(name)==false){
                    System.out.println("없는 항목입니다.");
                    continue;
                } else {
                	map.remove(name);
                    System.out.println( name + "이 삭제 되었습니다.");
                }
                
            } else if(select==2) {//찾기
            	System.out.print("찾을 이름>>");   name = key.next();
            	
            	System.out.println("이름>>"+name);
            	System.out.println("주소>>"+map.get(name).getAddr());
            	System.out.println("전화번호>>"+map.get(name).getNumber());
            	
            } else if(select==3) {//전체보기
                for (Map.Entry<String, Phone> e : map.entrySet() ) {
                	System.out.println("이름>>"+e.getKey());
                	System.out.println("주소>>"+e.getValue().getAddr());
                	System.out.println("전화번호>>"+e.getValue().getNumber());
                	System.out.println("----------------------------------");
					
				}
            } else if(select==4) {//종료
                break;
            } else {//잘못된값입력
                System.out.println("잘못된 값을 입력");
                continue;
            }
        }
        
    }
    
}
