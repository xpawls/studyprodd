package java22.junit;

import java.util.Scanner;


public class Student {
    
    private static int score = 0;
    private static String name = null;
    
    public static void main(String[] args){
        Scanner ke = new Scanner(System.in);
        
        for(;;){
            System.out.print("점수를 입력하세요(0~100) : ");
            score = ke.nextInt();
            if(score<=100 && score>=0){
                name = getgrade(score);
                break;
            } else {
                System.out.println("0~100 값을 입력하세요.");
                continue;
            }
        }
        
        System.out.println("학점은 " + name);
        
    }
    
    public static String getgrade(int i){
        String result = null;
        if(i>=90 && i<=100){
            result = "A";
        } else if (i>=80 && i<90){
            result = "B";
        } else if (i>=70 && i<80) {
            result = "C";
        } else if (i>=60 && i<70) {
            result = "D";
        } else {
            result = "F";
        }
        return result;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Student.score = score;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Student.name = name;
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
}
