package 김형남;

import java.util.Scanner;

public class ex5 {
    
    public static void main(String[] args) {
        Scanner ke = new Scanner(System.in);
        Employee[] employees = new Employee[3];
        
        for(int i=0; i<employees.length; i++){
            employees[i] = new Employee();
            System.out.print("name : ");
            employees[i].setName(ke.next());
            System.out.print("addr : ");
            employees[i].setAddr(ke.next());
            System.out.print("salary : ");
            employees[i].salary = ke.nextInt();
            System.out.print("rnn : ");
            employees[i].setRnn(ke.next());
        }
        
        for(int i=0; i<employees.length; i++){
            System.out.println(employees[i].toString());
        }
        
    }
    
}
