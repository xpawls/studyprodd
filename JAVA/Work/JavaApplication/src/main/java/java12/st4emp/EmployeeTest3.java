package java12.st4emp;

import java.util.Scanner;

public class EmployeeTest3 {
    public static void main(String[] args){
        
        int s;
        String n, a, r;
        
        Scanner key = new Scanner(System.in);
        
        Employee[] employees = null;
        employees = new Employee[3];
        
        for(int i=0; i<3; i++){
            
            System.out.println("이름을 입력하세요 : ");
            n = key.next();            
            System.out.println("월급을 입력하세요 : ");
            s = key.nextInt();            
            System.out.println("주소를 입력하세요 : ");
            a = key.next();            
            System.out.println("주민번호를 입력하세요 : ");
            r = key.next();
            employees[i]=new Employee(n, s, a, r);
            
        }
        
        for(Employee e : employees){
            System.out.println(e);
        }
        
    }
}
