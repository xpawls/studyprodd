package java19.st3studentmap;

import java.util.HashMap;
import java.util.Map;

public class TestStudent {
    
    public static void main(String[] args) {
        // HashMap 인스턴스 생성
        Map<String, Student> map = new HashMap<>();
        Student s = new Student();
        
        // map에 추가
        // key   --> (이름, 학번)
        // 170101--> new Student(구준표, 170101)
        // 170102--> new Student(금잔디, 170102)
        // 170103--> new Student(윤지후, 170103)
        map.put("170101", new Student(170101, "구준표"));
        map.put("170102", new Student(170102, "금잔디"));
 //       map.put("170103", s= new Student(170103, "윤지후"));
        map.put("170103", new Student(170103, "윤지후"));
        
        
        // entrySet, foreach map 에 항목 출력.
        printMap(map);
        
       
        // 학번 170102를 삭제.
        System.out.println("학번 170102를 삭제");
        map.remove("170102");
        printMap(map);
        // 윤지후가 "윤후"로 개명.
        // 1. 새로운 인스턴스
        // 2. 기존값을 변경
        Integer key =0;
        for (Student d : map.values()) {
            if(d.getName().equals("윤지후")){
                key = d.getNumber();
                break;
            }
        }
        map.put(String.valueOf(key), new Student(170103,"윤후"));
 //       s.setName("윤후");
 //       System.out.println("윤지후가 윤후로 개명");
 //       map.put("170103", s);
        printMap(map);
        
    }

    public static void printMap(Map<String, Student> map) {
        System.out.print("학생 목록 출력 >>");
        for (Map.Entry<String,Student> e : map.entrySet()) {
            int no = e.getValue().getNumber();
            String name =  e.getValue().getName();
            System.out.format("(학번: %7d, 이름:%3s), ",no ,name);
        }
        System.out.println();
    }
    
}
