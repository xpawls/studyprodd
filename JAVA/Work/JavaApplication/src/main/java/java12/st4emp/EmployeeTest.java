package java12.st4emp;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args){
        
        int s;
        String n, a, r;
        Employee emp = new Employee();
        Scanner key = new Scanner(System.in);
        
        String[] employees = new String[3];
        for(int i=0; i<3; i++){
            System.out.println("이름을 입력하세요 : ");
            n = key.next();
            emp.setName(n);
            System.out.println("월급을 입력하세요 : ");
            s = key.nextInt();
            emp.setSalary(s);
            System.out.println("주소를 입력하세요 : ");
            a = key.next();
            emp.setAddress(a);
            System.out.println("주민번호를 입력하세요 : ");
            r = key.next();
            emp.setRnn(r);
            employees[i] = emp.toString();
        }
        for(int i=0; i<employees.length; i++){
            System.out.println(employees[i]);
        }
        
        
    }
}
