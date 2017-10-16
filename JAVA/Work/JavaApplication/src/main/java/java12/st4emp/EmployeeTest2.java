package java12.st4emp;

import java.util.Scanner;

public class EmployeeTest2 {
    public static void main(String[] args){
        
        int s;
        String n, a, r;
        
        Scanner key = new Scanner(System.in);
        
        Employee[] employees = null;
        employees = new Employee[3];
        
        for(int i=0; i<3; i++){
            employees[i]=new Employee();
            System.out.println("이름을 입력하세요 : ");
            n = key.next();            
            System.out.println("월급을 입력하세요 : ");
            s = key.nextInt();            
            System.out.println("주소를 입력하세요 : ");
            a = key.next();            
            System.out.println("주민번호를 입력하세요 : ");
            r = key.next();
            
            employees[i].setName(n);
            employees[i].setSalary(s);
            employees[i].setAddress(a);
            employees[i].setRnn(r);
        }
        for(int i=0; i<employees.length; i++){
            System.out.println(employees[i].toString());
        }
        
        
    }
}
