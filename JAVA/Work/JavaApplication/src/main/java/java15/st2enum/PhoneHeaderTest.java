package java15.st2enum;

import java.util.Scanner;

public class PhoneHeaderTest {
    
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("번호 입력: ");
        String phone = key.next();
        
        String header = phone.substring(0, 3);
        
        
        
        if(header.equals(PhoneHeaderClass.P010)){
            System.out.println("general");
        } else if (header.equals(PhoneHeaderClass.P011)) {
            System.out.println("sk");
        } else if (header.equals(PhoneHeaderClass.P016)) {
            System.out.println("kt");
        } else if (header.equals(PhoneHeaderClass.P019)) {
            System.out.println("lg");
        } else {
            System.out.println("존재하지 않음");
        }
        
        if(header.equals(PhoneHeaderEnum.P010.getValue())){
            System.out.println("general");
        } else if (header.equals(PhoneHeaderEnum.P011.getValue())) {
            System.out.println("sk");
        } else if (header.equals(PhoneHeaderEnum.P016.getValue())) {
            System.out.println("kt");
        } else if (header.equals(PhoneHeaderEnum.P019.getValue())) {
            System.out.println("lg");
        } else {
            System.out.println("존재하지 않음");
        }
    }
    
}
